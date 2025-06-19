# 装饰器模式

装饰器模式（Decorator Pattern） 是指在不改变原有对象的基础上，将功能附加到对象上。  
提供了比继承更有贪心的替代方案（扩展原有对象的功能），属于结构型模式。

举例：比如在生活中，手抓饼加一个鸡蛋、一根香肠。给蛋糕加上一些水果。  
为对象扩展一些额外的职责。

装饰者在代码程序中适用于以下场景：
1. 用于扩展一个类的功能或给一个类添加附加职责。
2. 动态的给一个对象添加功能，这些功能可以再动态的撤销。

# 源码

1. JDK 中体现最明显的就是 IO 相关的类。如：BufferedReader、InputStream、OutputStream。
2. Spring 中的 TransactionAwareCacheDecorator 类，主要是用来处理事务缓存的，对 Cache 的一个包装。
3. SpringMVC 中的 HttpHeadResponseDecorator 类。

# 简单例子

![类图](https://rcbb-blog.oss-cn-guangzhou.aliyuncs.com/2022/06/20220627171555-4dcfca.png?x-oss-process=style/yuantu_shuiyin)

```
public static void main(String[] args) {
    Battercake battercake;
    // 初始化一个最基础的鸡蛋灌饼
    battercake = new BaseBattercake();
    // 加了个鸡蛋
    battercake = new EggDecorator(battercake);
    // 加了个香肠
    battercake = new SausageDecorator(battercake);
    // 加了个香肠
    battercake = new SausageDecorator(battercake);
    System.out.println(battercake.getMsg());
    System.out.println(battercake.getPrice());
}
```

# 读写实战

# SpringBoot实战

需求：在参数解析中增加一个 timestamp 字段，存放的值是当前的毫秒时间戳。

例如这个 test 方法，接收的数据存放在`Map<String, Object> params`中，如何在原本的参数中增加一些内容。

```java
@RequestMapping("/test")
public Map<String, Object> test(@RequestBody Map<String, Object> params) {
    return params;
}
```

如果使用装饰器模式的思想，就是在原本解析的功能上再加上一个功能。

功能实现：解析的同时，添加一个参数。

## 自定义注解

首先自定义一个注解。

```java
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimestampRequestBody {

}
```

## 自定义处理逻辑

模仿 RequestResponseBodyMethodProcessor 进行自定义实现。

```java
public class TimestampRequestResponseBodyMethodProcessor implements HandlerMethodArgumentResolver {

    RequestResponseBodyMethodProcessor processor;
    ApplicationContext applicationContext;

    public TimestampRequestResponseBodyMethodProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TimestampRequestBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        setupProcessor();
        Object result = processor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        if (!(result instanceof Map<?, ?>)) {
            return result;
        }
        ((Map) result).put("timestamp", System.currentTimeMillis());
        return result;
    }

    private void setupProcessor() {
        if (this.processor != null) {
            return;
        }
        RequestMappingHandlerAdapter adapter = this.applicationContext.getBean(RequestMappingHandlerAdapter.class);
        List<HandlerMethodArgumentResolver> argumentResolvers = adapter.getArgumentResolvers();
        for (HandlerMethodArgumentResolver argumentResolver : argumentResolvers) {
            if (argumentResolver instanceof RequestResponseBodyMethodProcessor) {
                this.processor = (RequestResponseBodyMethodProcessor) argumentResolver;
                break;
            }
        }
    }
}
```

## 装配自定义处理逻辑

将 TimestampRequestResponseBodyMethodProcessor 进行装配。

```java
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TimestampRequestResponseBodyMethodProcessor(applicationContext));
    }

}

```

## 测试

使用 @TimestampRequestBody 进行测试。

```java
@RequestMapping("/test1")
public Map<String, Object> test1(@TimestampRequestBody Map<String, Object> params) {
    return params;
}
```

## 源码解析

### 一、实现的思路从哪来？

通过 debug @RequestBody 的解析流程。

### 二、@RequestBody核心源码跟踪

1. 首先在 controller 中打断点，得到 params。在 debug 调用栈中可以找到核心的方法。`InvocableHandlerMethod#invokeForRequest`
2. 其中核心的代码为`Object[] args = getMethodArgumentValues(request, mavContainer, providedArgs);`
3. getMethodArgumentValues 中发现`if (!this.resolvers.supportsParameter(parameter))`，判断是否有对应的解析器支持。有则对传入的参数进行匹配后进行解析。
4. 继续往下跟进`HandlerMethodArgumentResolverComposite#resolveArgument`。
5. 首先第一点看到名称就可以知道`xxxComposite`，这可能是个组合模式，观察源码发现其含有`private final List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>();`一大堆的解析器。
6. `HandlerMethodArgumentResolver resolver = getArgumentResolver(parameter);`断点到这里就匹配出来了`RequestResponseBodyMethodProcessor`。
7. 就是经过这一行代码处理进行的参数解析`resolver.resolveArgument(parameter, mavContainer, webRequest, binderFactory);`。
8. 向上我们发现其接口为`org.springframework.web.method.support.HandlerMethodArgumentResolver`。
9. 所以，我们需要来实现自己的解析器来达成我们的需求。

上文中出现的完整类名顺序如下。
- org.springframework.web.method.support.InvocableHandlerMethod#invokeForRequest
- org.springframework.web.method.support.HandlerMethodArgumentResolverComposite#resolveArgument
- org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor
- org.springframework.web.method.support.HandlerMethodArgumentResolver

### 三、自定义的解析器如何装配

1. 在`HandlerMethodArgumentResolverComposite`中发现有三个`addResolver`方法，都打上断点。
2. 重启服务，进入断点。
3. 跟踪到了`RequestMappingHandlerAdapter#afterPropertiesSet`初始化方法。
4. 发现`RequestMappingHandlerAdapter#getDefaultArgumentResolvers`在这里进行了一下解析器的初始化。并且给用户预留了 Custom arguments。
5. 然后断点`RequestMappingHandlerAdapter#setCustomArgumentResolvers`。
6. 发现`WebMvcConfigurationSupport#requestMappingHandlerAdapter`，其中的核心方法`WebMvcConfigurationSupport#getArgumentResolvers`。
7. `WebMvcConfigurationSupport#getArgumentResolvers`很明显是一个懒加载，加载方法为`WebMvcConfigurationSupport#addArgumentResolvers`，该方法为空实现，往下只有一个具体实现子类`DelegatingWebMvcConfiguration#addArgumentResolvers`。
8. `DelegatingWebMvcConfiguration`中的`configurers`由`@Autowired(required = false)`扫描添加的。
9. `WebMvcConfigurer#addArgumentResolvers`在 WebMvcConfigurer 中添加解析器。
10. 所以，我们实现一个自己的 WebMvcConfigurer，然后添加自定义的解析器即可。

上文中出现的完整类名顺序如下。
- org.springframework.web.method.support.HandlerMethodArgumentResolverComposit
- org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#afterPropertiesSet
- org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#getDefaultArgumentResolvers
- org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#setCustomArgumentResolvers
- org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#requestMappingHandlerAdapter
- org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#getArgumentResolvers
- org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#addArgumentResolvers
- org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration#addArgumentResolvers
- org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addArgumentResolvers

### 四、TimestampRequestResponseBodyMethodProcessor实现细节

TimestampRequestResponseBodyMethodProcessor 中为什么需要有`RequestResponseBodyMethodProcessor`和`ApplicationContext`？

我们不需要关注解析的细节，直接使用`RequestResponseBodyMethodProcessor`即可。
但是问题是`RequestResponseBodyMethodProcessor`从何而来？
`RequestMappingHandlerAdapter#getDefaultArgumentResolvers`通过源码发现，`RequestResponseBodyMethodProcessor`是被直接 new 出来的，并不能直接通过`@Autowired`让容器自动装配。

那看看`RequestResponseBodyMethodProcessor`被谁持有？

被`RequestMappingHandlerAdapter`持有并且它实现了`implements BeanFactoryAware, InitializingBean`，代表可以通过Spring 容器获得它。
可以通过`RequestMappingHandlerAdapter#getArgumentResolvers`获取到所有的解析器。


上文中出现的完整类名顺序如下。
- org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor
- org.springframework.context.ApplicationContext
- org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#getDefaultArgumentResolvers
- org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#getArgumentResolvers

### 五、为啥不直接在自定义的WebMvcConfigurer中直接获取RequestMappingHandlerAdapter往下传递？

会出现依赖循环，所以使用`ApplicationContext`在`TimestampRequestResponseBodyMethodProcessor`中进行懒加载处理`TimestampRequestResponseBodyMethodProcessor#setupProcessor`。

```
┌─────┐
|  myWebMvcConfigurer (field private org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter cc.rcbb.design.partterns.decorator.config.MyWebMvcConfigurer.adapter)
↑     ↓
|  org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration
└─────┘
```

# 参考

- [文章中的源代码](https://github.com/rcbb-cc/design-patterns)
- [学java的生生-【设计模式实战】装饰器模式](https://www.bilibili.com/video/BV17iFfeWEqc)
