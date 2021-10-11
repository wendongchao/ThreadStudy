package com.thread.waitnotify.pojo;

/**
 * @author wendongchao
 * @ClassName ThreadA01
 * @Date 2021/10/11 17:12
 */
public class ThreadA02 extends Thread {
    private Object lock;
    public ThreadA02(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (ThreadPo02.size() != 5) {
                    System.out.println("wait begin time="+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end time="+System.currentTimeMillis());
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
