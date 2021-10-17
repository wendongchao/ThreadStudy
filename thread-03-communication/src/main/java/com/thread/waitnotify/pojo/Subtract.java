package com.thread.waitnotify.pojo;

/**
 * @Author wendongchao
 * @Date 2021/10/17 17:21
 */
public class Subtract {
    private String lock;
    public Subtract(String lock) {
        this.lock = lock;
    }
    public void subtract() {
        try {
            synchronized (lock) {
                while (ValueObject.list.size() ==0) {
                    System.out.println("wait begin name="+Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end name="+Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size="+ValueObject.list.size());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
