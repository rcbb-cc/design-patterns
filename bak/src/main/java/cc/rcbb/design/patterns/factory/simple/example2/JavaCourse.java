package cc.rcbb.design.patterns.factory.simple.example2;

/**
 * <p>
 * JavaCourse
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
