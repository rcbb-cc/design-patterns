package cc.rcbb.design.patterns.facade.example1;

/**
 * <p>
 * ConfigModel 示意配置描述的数据Model，真实的配置数据会很多
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/6
 */
public class ConfigModel {
    /**
     * 是否需要生成表现层，默认是true
     */
    private boolean needGenPresentation = true;
    /**
     * 是否需要生成逻辑层，默认是true
     */
    private boolean needGenBusiness = true;
    /**
     * 是否需要生成DAO，默认是true
     */
    private boolean needGenDAO = true;

    public boolean isNeedGenPresentation() {
        return needGenPresentation;
    }

    public void setNeedGenPresentation() {
        this.needGenPresentation = needGenPresentation;
    }

    public boolean isNeedGenBusiness() {
        return needGenBusiness;
    }

    public void setNeedGenBusiness(boolean needGenBusiness) {
        this.needGenBusiness = needGenBusiness;
    }

    public boolean isNeedGenDAO() {
        return needGenDAO;
    }

    public void setNeedGenDAO(boolean needGenDAO) {
        this.needGenDAO = needGenDAO;
    }
}
