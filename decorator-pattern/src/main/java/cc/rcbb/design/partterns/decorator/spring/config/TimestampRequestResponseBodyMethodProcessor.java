package cc.rcbb.design.partterns.decorator.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * TimestampRequestResponseBodyMethodProcessor
 * </p>
 *
 * @author rcbb.cc
 * @date 2025/6/16
 */
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
