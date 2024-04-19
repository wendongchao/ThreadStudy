package condition;

/**
 * https://www.cnblogs.com/java-bible/p/13930006.html
 * @auther wendongchao
 * @date 2024/4/19 14:16
 **/
public class LockConditionDemo {
    public static void main(String[] args) {
        Message message = new Message();
        Thread producer = new Thread(new MessageProducer(message));
        Thread consumer = new Thread(new MessageConsumer(message));
        producer.start();
        consumer.start();
    }
}
