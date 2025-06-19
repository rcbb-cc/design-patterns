package cc.rcbb.design.patterns.factory.method.example1;

/**
 * <p>
 * Client
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/11
 */
public class Client {

    public static void main(String[] args) {
        ExportOperate operate = new ExportDBOperate();
        operate.export("测试数据");
    }

}
