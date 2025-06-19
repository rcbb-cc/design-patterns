package cc.rcbb.design.patterns.factory.simple.example2;

/**
 * <p>
 * PythonCourse
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
