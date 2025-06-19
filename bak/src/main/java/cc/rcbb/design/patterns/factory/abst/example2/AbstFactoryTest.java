package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * AbstFactoryTest
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public class AbstFactoryTest {

    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        INote note = factory.createNote();
        note.edit();
        IVideo video = factory.createVideo();
        video.record();
    }

}
