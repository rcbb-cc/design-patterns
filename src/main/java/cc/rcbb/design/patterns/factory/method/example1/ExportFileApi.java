package cc.rcbb.design.patterns.factory.method.example1;

/**
 * <p>
 * ExportFileApi 导出的文件对象的接口
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public interface ExportFileApi {

    /**
     * 导出内容成为文件
     *
     * @param data 示意：需要保存的数据
     * @return 是否导出成功
     */
    boolean export(String data);

}
