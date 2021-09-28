package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO202 {
    public void printStr() {
        synchronized (this) {
            System.out.println("print getLock time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
            System.out.println("----------------------");
            System.out.println("print releaseLock time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
        }
    }
}
