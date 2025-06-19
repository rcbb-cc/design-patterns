package cc.rcbb.design.patterns.builder.example2;

/**
 * <p>
 * ExportHeaderModel  描述输出到文件头的内容的对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/30
 */
public class ExportHeaderModel {

    /**
     * 分公司或门市点编号
     */
    private String depId;
    /**
     * 导出数据的日期
     */
    private String exportDate;
    public String getDepId() {
        return depId;
    }
    public void setDepId(String depId) {
        this.depId = depId;
    }
    public String getExportDate() {
        return exportDate;
    }
    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

}
