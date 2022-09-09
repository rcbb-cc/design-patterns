package cc.rcbb.design.patterns.bridge.example1;

/**
 * <p>
 * MessageMobile 以手机短消息的方式发送消息
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/9
 */
public class MessageMobile implements MessageImplementor {

    @Override
    public void send(String message, String toUser) {
        System.out.println("使用手机短消息的方式，发送消息'" + message + "'给" + toUser);
    }

}
