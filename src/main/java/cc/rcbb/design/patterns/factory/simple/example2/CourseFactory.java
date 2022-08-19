package cc.rcbb.design.patterns.factory.simple.example2;

/**
 * <p>
 * CourseFactory
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class CourseFactory {

    public static ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("python".equals(name)) {
            return new PythonCourse();
        }
        throw new RuntimeException("无匹配name");
    }

}
