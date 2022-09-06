package cc.rcbb.design.patterns.facade.example1;

/**
 * <p>
 * Facade 代码生成子系统的外观对象
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/6
 */
public class Facade {

    /**
     * 客户端需要的，一个简单的调用代码生成的功能
     */
    public void generate() {
        new Presentation().generate();
        new Business().generate();
        new DAO().generate();
    }

}
