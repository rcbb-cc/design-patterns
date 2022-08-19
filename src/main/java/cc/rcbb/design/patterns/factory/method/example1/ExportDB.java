package cc.rcbb.design.patterns.factory.method.example1;

/**
 * <p>
 * ExportDB  导出成数据库备份文件形式的对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class ExportDB implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.println("导出 " + data + " 到数据库备份文件");
        return true;
    }
}
