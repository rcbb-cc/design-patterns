package cc.rcbb.design.patterns.decorator.example1;

import java.util.Date;

/**
 * <p>
 * ConcreteComponent 基本的实现计算奖金的类，也是被装饰器装饰的对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/21
 */
public class ConcreteComponent extends Component {
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //只是一个默认的实现，默认没有奖金
        return 0;
    }
}
