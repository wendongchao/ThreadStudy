package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 20:09
 */
public class SynchronizedThreadPO201 {
    public void method(SynchronizedThreadPO202 po202) {
        synchronized (po202) {
            try {
                System.out.println("getLock time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
                Thread.sleep(100);
                System.out.println("releaseLock time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
