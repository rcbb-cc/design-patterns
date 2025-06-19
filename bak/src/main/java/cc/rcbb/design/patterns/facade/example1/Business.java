package cc.rcbb.design.patterns.facade.example1;

/**
 * <p>
 * Business 示意生成逻辑层的模块
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/6
 */
public class Business {
    public void generate() {
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenBusiness()) {
            System.out.println("正在生成逻辑层代码文件");
        }
    }
}
