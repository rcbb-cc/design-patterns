package cc.rcbb.design.patterns.decorator;

/**
 * <p>
 * BattercakeTest
 * </p>
 *
 * @author lvhao
 * @date 2022/5/27
 */
public class BattercakeTest {
    
    public static void main(String[] args) {
        Battercake battercake;
        
        battercake = new BaseBattercake();
        
        battercake = new EggDecorator(battercake);
        
        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        
        System.out.println(battercake.getMsg());
        System.out.println(battercake.getPrice());
        
    }
    
}
