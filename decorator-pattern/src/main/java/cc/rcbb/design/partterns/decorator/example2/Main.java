package cc.rcbb.design.partterns.decorator.example2;

/**
 * <p>
 * Main
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/5/27
 */
public class Main {

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

}
