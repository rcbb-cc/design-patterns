package cc.rcbb.design.patterns.factory.abst.example1;

/**
 * <p>
 * CPUFactory
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/12
 */
public class CPUFactory {

    /**
     * 创建CPU接口对象的方法
     *
     * @param type 选择CPU类型的参数
     * @return CPU接口对象的方法
     */
    public static CPUApi createCPUApi(int type) {
        CPUApi cpu = null;
        // 根据参数来选择并创建相应的CPU对象
        if (type == 1) {
            cpu = new IntelCPU(1156);
        } else if (type == 2) {
            cpu = new AMDCPU(939);
        }
        return cpu;
    }
}
