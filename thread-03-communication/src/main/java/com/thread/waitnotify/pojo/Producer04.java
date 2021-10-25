package com.thread.waitnotify.pojo;

/**
 * 生产者
 * @author wendongchao
 * @ClassName Producer04
 * @Date 2021/10/24 21:57
 */
public class Producer04 {
    private String lock;
    public Producer04(String lock) {
        this.lock = lock;
    }
    public void setValue() {
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值是："+value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
