package cc.rcbb.design.patterns.singleton;

/**
 * <p>
 * LazySingleton 懒汉式单例实现
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/22
 */
public class LazySingleton {

    /**
     * 定义一个变量来存储创建好的类实例
     */
    private static LazySingleton instance = null;

    /**
     * 私有化构造方法，好在内部控制创建实例的数目
     */
    private LazySingleton() {

    }

    /**
     * 定义一个方法来为客户端提供实例
     *
     * @return
     */
    public static synchronized LazySingleton getInstance() {
        // 判断存储实例的变量是否有值
        if (instance == null) {
            // 如果没有，就创建一个类实例，并将值赋予给存储类实例的变量
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 示意方法，单例可以有自己的操作
     */
    public void operation() {
        // 功能处理
    }

    /**
     * 示意属性，单例可以有自己的属性
     */
    private String data;

    /**
     * 示意方法，让外部通过这些方法来访问属性的值
     *
     * @return
     */
    public String getData() {
        return data;
    }
}
