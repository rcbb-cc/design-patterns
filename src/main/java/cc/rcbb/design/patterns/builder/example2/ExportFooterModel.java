package cc.rcbb.design.patterns.builder.example2;

/**
 * <p>
 * ExportFooterModel 描述输出到文件尾的内容的对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/30
 */
public class ExportFooterModel {
    /**
     * 输出人
     */
    private String exportUser;

    public String getExportUser() {
        return exportUser;
    }

    public void setExportUser(String exportUser) {
        this.exportUser = exportUser;
    }
}
