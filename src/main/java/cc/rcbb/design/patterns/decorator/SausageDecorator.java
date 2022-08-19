package cc.rcbb.design.patterns.decorator;

/**
 * <p>
 * SausageDecorator
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/5/27
 */
public class SausageDecorator extends BattercakeDecotator {
    
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }
    
    @Override
    protected void doSomething() {
    
    }
    
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }
    
    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
