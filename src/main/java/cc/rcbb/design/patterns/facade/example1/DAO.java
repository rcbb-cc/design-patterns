package cc.rcbb.design.patterns.facade.example1;

/**
 * <p>
 * DAO 示意生成数据层的模块
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/6
 */
public class DAO {
    public void generate() {
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenDAO()) {
            System.out.println("正在生成数据层代码文件");
        }
    }
}
