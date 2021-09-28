package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO181 {
    public void method(SynchronizedThreadPO182 po182) {
        synchronized (po182) {
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
