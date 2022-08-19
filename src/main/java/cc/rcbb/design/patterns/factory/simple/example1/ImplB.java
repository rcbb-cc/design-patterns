package cc.rcbb.design.patterns.factory.simple.example1;

/**
 * <p>
 * ImplB
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class ImplB implements Api {
    @Override
    public void operation(String s) {
        // 实现功能的代码，示意一下
        System.out.println("ImplB s==" + s);
    }
}
