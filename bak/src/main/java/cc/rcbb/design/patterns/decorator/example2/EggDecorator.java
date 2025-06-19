package cc.rcbb.design.patterns.decorator.example2;

/**
 * <p>
 * EggDecorator
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/5/27
 */
public class EggDecorator extends BattercakeDecotator {
    
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }
    
    @Override
    protected void doSomething() {
    
    }
    
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }
    
    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
