package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * PythonNote
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写Python笔记");
    }
}
