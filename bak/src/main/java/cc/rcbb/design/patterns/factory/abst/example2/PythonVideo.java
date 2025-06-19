package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * PythonVideo
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public class PythonVideo implements IVideo{
    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
