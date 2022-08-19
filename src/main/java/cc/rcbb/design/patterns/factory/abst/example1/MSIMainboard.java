package cc.rcbb.design.patterns.factory.abst.example1;

/**
 * <p>
 * MSIMainboard 微星的主板
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/12
 */
public class MSIMainboard implements MainboardApi {
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     *
     * @param cpuHoles CPU插槽的孔数
     */
    public MSIMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("now in MSIMainboard,cpuHoles=" + cpuHoles);
    }
}
