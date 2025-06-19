package cc.rcbb.design.patterns.bridge.example1;

/**
 * <p>
 * MessageImplementor 实现发送消息的统一接口
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/9
 */
public interface MessageImplementor {
    /**
     * 发送消息
     *
     * @param message 要发送的消息内容
     * @param toUser  消息发送的目的人员
     */
    void send(String message, String toUser);
}
