package cc.rcbb.design.patterns.singleton.example1;

/**
 * <p>
 * AppConfig 读取应用配置文件，单例实现
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/22
 */
public class AppConfig {
    /**
     * 定义一个变量来存储创建好的类的实例
     * 直接创建，只会创建一次
     */
    private static AppConfig instance = new AppConfig();

    /**
     * 定义一个方法来为客户端提供 AppConfig 类的实例
     *
     * @return
     */
    public static AppConfig getInstance() {
        return instance;
    }

    /**
     * 参数A
     */
    private String parameterA;

    /**
     * 参数B
     */
    private String parameterB;

    public String getParameterA() {
        return parameterA;
    }

    public String getParameterB() {
        return parameterB;
    }

    /**
     * 私有化构造方法
     */
    private AppConfig() {
        // 读取配置文件
        readConfig();
    }

    /**
     * 读取配置文件
     */
    private void readConfig() {
        // 省去读取配置文件的代码
        this.parameterA = "paramA";
        this.parameterB = "paramB";
    }


}
