package cc.rcbb.design.patterns.facade.example1;

/**
 * <p>
 * Client
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/6
 */
public class Client {

    public static void main(String[] args) {
        //使用Facade
        new Facade().generate();
    }

}
