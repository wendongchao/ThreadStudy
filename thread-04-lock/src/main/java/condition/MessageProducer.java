package condition;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者
 * @auther wendongchao
 * @date 2024/4/19 14:15
 **/
public class MessageProducer implements Runnable{

    private Message message;

    public MessageProducer(Message message) {
        this.message = message;
    }
    @Override
    public void run() {
        produce();
    }

    public void produce() {
        List<String> msgs = new ArrayList<>();
        msgs.add("begin");
        msgs.add("msg1");
        msgs.add("msg2");
        for (String msg : msgs) {
            message.produce(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        message.produce("end");
        message.setEnd(true);
    }
}
