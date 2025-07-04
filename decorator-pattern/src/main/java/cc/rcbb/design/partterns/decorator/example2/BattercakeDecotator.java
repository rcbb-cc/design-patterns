package cc.rcbb.design.partterns.decorator.example2;

/**
 * <p>
 * BattercakeDecotator
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/5/27
 */
public abstract class BattercakeDecotator extends Battercake {

    private Battercake battercake;

    public BattercakeDecotator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
