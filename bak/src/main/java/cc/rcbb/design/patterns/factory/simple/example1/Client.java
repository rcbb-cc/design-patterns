package cc.rcbb.design.patterns.factory.simple.example1;

/**
 * <p>
 * Client
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class Client {

    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        api.operation("正在使用简单工厂");
    }

}
