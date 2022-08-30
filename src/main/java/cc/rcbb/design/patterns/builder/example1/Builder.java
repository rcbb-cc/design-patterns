package cc.rcbb.design.patterns.builder.example1;

/**
 * <p>
 * Builder 生成器接口，定义创建一个产品对象所需的各个部件的操作
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/30
 */
public interface Builder {

    /**
     * 示意方法，构建某个部件
     */
    void buildPart();
}
