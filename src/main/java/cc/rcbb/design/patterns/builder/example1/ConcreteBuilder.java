package cc.rcbb.design.patterns.builder.example1;

/**
 * <p>
 * ConcreteBuilder 具体的生成器实现对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/30
 */
public class ConcreteBuilder implements Builder {

    /**
     * 生成器最终构建的产品对象
     */
    private Product resultProduct;

    /**
     * 获取生成器最终构建的产品对象
     *
     * @return 生成器最终构建的产品对象
     */
    public Product getResult() {
        return resultProduct;
    }

    @Override
    public void buildPart() {
        //构建某个部件的功能处理
    }
}
