package cc.rcbb.design.patterns.factory.method.example1;

/**
 * <p>
 * ExportDBOperate 体的创建器实现对象，实现创建导出成数据库备份文件形式的对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class ExportDBOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportDB();
    }
}
