package cc.rcbb.design.patterns.decorator.example1;

/**
 * <p>
 * Client
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/21
 */
public class Client {

    public static void main(String[] args) {
        //先创建计算基本奖金的类，这也是被装饰的对象
        Component c1 = new ConcreteComponent();

        //然后对计算的基本奖金进行装饰，这里要组合各个装饰
        //说明，各个装饰者之间最好是不要有先后顺序的限制，
        //也就是先装饰谁和后装饰谁都应该是一样的

        //先组合普通业务人员的奖金计算
        Decorator d1 = new MonthPrizeDecorator(c1);
        Decorator d2 = new SumPrizeDecorator(d1);

        //注意：这里只需使用最后组合好的对象调用业务方法即可，会依次调用回去
        //日期对象都没有用上，所以传null就可以了
        double zs = d2.calcPrize("张三", null, null);
        System.out.println("应得奖金：" + zs + "\n");
        double ls = d2.calcPrize("李四", null, null);
        System.out.println("应得奖金：" + ls + "\n");

        //如果是业务经理，还需要一个计算团队的奖金计算
        Decorator d3 = new GroupPrizeDecorator(d2);
        double ww = d3.calcPrize("王五", null, null);
        System.out.println("应得奖金：" + ww + "\n");
    }

}
