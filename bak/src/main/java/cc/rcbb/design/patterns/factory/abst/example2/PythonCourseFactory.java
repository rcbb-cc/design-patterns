package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * PythonCourseFactory
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
