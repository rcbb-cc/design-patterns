package cc.rcbb.design.patterns.decorator.example1;

import java.util.Date;

/**
 * <p>
 * Decorator 装饰器的接口，需要跟被装饰的对象实现同样的接口
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/21
 */
public class Decorator extends Component {
    /**
     * 持有被装饰的组件对象
     */
    protected Component c;

    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param c 被装饰的对象
     */
    public Decorator(Component c) {
        this.c = c;
    }

    public double calcPrize(String user, Date begin, Date end) {
        //转调组件对象的方法
        return c.calcPrize(user, begin, end);
    }
}
