package cc.rcbb.design.patterns.factory.abst.example1;

/**
 * <p>
 * Client
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/8/12
 */
public class Client {

    public static void main(String[] args) {
        // 创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();
        // 告诉装机工程师自己选择的配件，让装机工程师组装电脑
        engineer.makeComputer(1, 1);
    }
}
