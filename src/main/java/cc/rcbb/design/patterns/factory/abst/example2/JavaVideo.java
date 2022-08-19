package cc.rcbb.design.patterns.factory.abst.example2;

/**
 * <p>
 * JavaVideo
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/19
 */
public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
