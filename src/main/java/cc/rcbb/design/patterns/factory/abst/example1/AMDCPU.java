package cc.rcbb.design.patterns.factory.abst.example1;

/**
 * <p>
 * AMDCPU MD的CPU实现
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/12
 */
public class AMDCPU implements CPUApi {
    /**
     * CPU的针脚数目
     */
    private int pins = 0;

    /**
     * 构造方法，传入CPU的针脚数目
     *
     * @param pins CPU的针脚数目
     */
    public AMDCPU(int pins) {
        this.pins = pins;
    }

    public void calculate() {
        System.out.println("now in AMD CPU,pins=" + pins);
    }
}
