package cc.rcbb.design.patterns.factory.method.example1;

/**
 * <p>
 * ExportTxtFileOperate 具体的创建器实现对象，实现创建导出成文本文件格式的对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class ExportTxtFileOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTxtFile();
    }
}
