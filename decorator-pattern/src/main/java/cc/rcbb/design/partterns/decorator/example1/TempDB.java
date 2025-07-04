package cc.rcbb.design.partterns.decorator.example1;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * TempDB 在内存中模拟数据库，准备点测试数据，好计算奖金
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/21
 */
public class TempDB {

    private TempDB() {
    }

    /**
     * 记录每个人的月度销售额，只用了人员，月份没有用
     */
    public static Map<String, Double> mapMonthSaleMoney = new HashMap<String, Double>();

    static {
        //填充测试数据
        mapMonthSaleMoney.put("张三", 10000.0);
        mapMonthSaleMoney.put("李四", 20000.0);
        mapMonthSaleMoney.put("王五", 30000.0);
    }

}
