package com.thread.waitnotify.pojo;

/**
 * @author wendongchao
 * @ClassName ThreadA01
 * @Date 2021/10/11 17:12
 */
public class ThreadB02 extends Thread {
    private Object lock;
    public ThreadB02(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    ThreadPo02.add();
                    if (ThreadPo02.size() == 5) {
                        lock.notify();
                        System.out.println("已发出通知");
                    }
                    System.out.println("添加了"+(i+1)+"个元素");
                    Thread.sleep(100);
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
