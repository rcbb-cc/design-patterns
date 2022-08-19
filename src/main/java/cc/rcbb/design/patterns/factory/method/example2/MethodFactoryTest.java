package cc.rcbb.design.patterns.factory.method.example2;

import cc.rcbb.design.patterns.factory.simple.example2.ICourse;

/**
 * <p>
 * MethodFactoryTest
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class MethodFactoryTest {

    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();
    }

}
