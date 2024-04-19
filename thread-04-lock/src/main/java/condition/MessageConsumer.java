package condition;

/**
 * 消费者
 * @auther wendongchao
 * @date 2024/4/19 14:14
 **/
public class MessageConsumer implements Runnable{

    private Message message;

    public MessageConsumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (!message.isEnd()) {
            message.consume();
        }
    }
}
