package cc.rcbb.design.patterns.singleton;

/**
 * <p>
 * HungerSingleton
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/22
 */
public class HungerSingleton {

    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton() {
    }

    public static HungerSingleton getInstance() {
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
