package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * JavaNote
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public class JavaNote implements INote {

    @Override
    public void edit() {
        System.out.println("编写Java笔记");
    }
}
