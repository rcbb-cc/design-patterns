package cc.rcbb.design.patterns.factory.method.example1;

/**
 * <p>
 * ExportTxtFile  导出成文本文件格式的对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class ExportTxtFile implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.println("导出 " + data + " 到文本文件");
        return true;
    }
}
