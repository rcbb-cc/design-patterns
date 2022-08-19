package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * JavaCourseFactory
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
