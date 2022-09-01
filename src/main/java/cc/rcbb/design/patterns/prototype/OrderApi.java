package cc.rcbb.design.patterns.prototype;

/**
 * <p>
 * OrderApi
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/1
 */
public interface OrderApi {

    int getOrderProductNum();

    void setOrderProductNum(int num);

    /**
     * 克隆方法
     *
     * @return 订单原型的实例
     */
    OrderApi cloneOrder();

}
