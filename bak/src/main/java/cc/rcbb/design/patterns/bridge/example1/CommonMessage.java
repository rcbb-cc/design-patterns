package cc.rcbb.design.patterns.bridge.example1;

/**
 * <p>
 * CommonMessage
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/9
 */
public class CommonMessage extends AbstractMessage {

    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        //对于普通消息，什么都不干，直接调父类的方法，把消息发送出去就可以了
        super.sendMessage(message, toUser);
    }
}
