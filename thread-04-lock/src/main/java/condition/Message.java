package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther wendongchao
 * @date 2024/4/19 14:14
 **/
public class Message {
    private final Lock lock = new ReentrantLock();

    private final Condition consumer_msg = lock.newCondition();

    private final Condition producer_msg = lock.newCondition();

    private String message;

    private boolean state;

    private boolean end;

    public void consume() {
        lock.lock();
        try {
            while (!state) {
                producer_msg.await();
            }
            System.out.println("consume message:"+message);
            state = false;
            consumer_msg.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void produce(String message) {
        lock.lock();
        try {
            while (state) {
                consumer_msg.wait();
            }
            System.out.println("produce message:"+message);
            this.message = message;
            state = true;
            producer_msg.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

}
