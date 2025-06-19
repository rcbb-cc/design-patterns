package cc.rcbb.design.patterns.composite.example1;

/**
 * <p>
 * Leaf 叶子对象，叶子对象不再包含其它子对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/14
 */
public class Leaf extends Component {

    /**
     * 叶子对象的名字
     */
    private String name = "";

    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 示意方法，叶子对象可能有自己的功能方法
     */
    @Override
    public void someOperation() {
        // do something
    }

    /**
     * 输出叶子对象的结构，叶子对象没有子对象，也就是输出叶子对象的名字
     *
     * @param preStr 前缀，主要是按照层级拼接的空格，实现向后缩进
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + " - " + name);
    }
}
