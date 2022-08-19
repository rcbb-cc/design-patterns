package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * CourseFactory
 * </p>
 * 抽象工厂是用户的主入口
 * 在 Spring 中应用得最为广泛的一种设计模式
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public interface CourseFactory {

    INote createNote();

    IVideo createVideo();

}
