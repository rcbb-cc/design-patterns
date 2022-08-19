package cc.rcbb.design.patterns.factory.method.example2;

import cc.rcbb.design.patterns.factory.simple.example2.ICourse;
import cc.rcbb.design.patterns.factory.simple.example2.JavaCourse;

/**
 * <p>
 * JavaCourseFactory
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
