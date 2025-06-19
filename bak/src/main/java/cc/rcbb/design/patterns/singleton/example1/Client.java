package cc.rcbb.design.patterns.singleton.example1;

/**
 * <p>
 * Client
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/22
 */
public class Client {

    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        String paramA = config.getParameterA();
        String paramB = config.getParameterB();
        System.out.println("paramA = " + paramA);
        System.out.println("paramB = " + paramB);
    }

}
