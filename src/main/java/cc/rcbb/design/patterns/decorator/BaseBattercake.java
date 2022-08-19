package cc.rcbb.design.patterns.decorator;

/**
 * <p>
 * BaseBattercake
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/5/27
 */
public class BaseBattercake extends Battercake {
    
    @Override
    protected String getMsg() {
        return "煎饼";
    }
    
    @Override
    protected int getPrice() {
        return 5;
    }
}
