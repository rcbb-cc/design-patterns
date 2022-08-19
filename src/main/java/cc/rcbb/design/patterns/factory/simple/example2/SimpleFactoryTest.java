package cc.rcbb.design.patterns.factory.simple.example2;

/**
 * <p>
 * SimpleFactoryTest
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        ICourse course = CourseFactory.create("java");
        course.record();
    }

}
