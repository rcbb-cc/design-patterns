package cc.rcbb.design.patterns.builder.example2;

import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * Builder 生成器接口，定义创建一个输出文件对象所需的各个部件的操作
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/30
 */
public interface Builder {
    /**
     * 构建输出文件的Header部分
     *
     * @param ehm 文件头的内容
     */
    void buildHeader(ExportHeaderModel ehm);

    /**
     * 构建输出文件的Body部分
     *
     * @param mapData 要输出的数据的内容
     */
    void buildBody(Map<String, Collection<ExportDataModel>> mapData);

    /**
     * 构建输出文件的Footer部分
     *
     * @param efm 文件尾的内容
     */
    void buildFooter(ExportFooterModel efm);
}
