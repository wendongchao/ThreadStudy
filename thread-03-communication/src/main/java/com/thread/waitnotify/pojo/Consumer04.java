package com.thread.waitnotify.pojo;

/**
 * 消费者
 * @author wendongchao
 * @ClassName Consumer04
 * @Date 2021/10/24 21:57
 */
public class Consumer04 {
    private String lock;
    public Consumer04(String lock) {
        this.lock = lock;
    }
    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值是："+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
