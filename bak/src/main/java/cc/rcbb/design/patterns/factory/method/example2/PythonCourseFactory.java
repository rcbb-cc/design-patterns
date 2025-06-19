package cc.rcbb.design.patterns.factory.method.example2;

import cc.rcbb.design.patterns.factory.simple.example2.ICourse;
import cc.rcbb.design.patterns.factory.simple.example2.PythonCourse;

/**
 * <p>
 * PythonCourseFactory
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
