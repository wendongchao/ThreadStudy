package com.thread.waitnotify.pojo;

/**
 * @author wendongchao
 * @ClassName ThreadA01
 * @Date 2021/10/11 17:12
 */
public class ThreadB01 extends Thread {
    private Object lock;
    public ThreadB01(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("notify begin time="+System.currentTimeMillis());
            lock.notify();
            System.out.println("notify end time="+System.currentTimeMillis());
        }
    }
}
