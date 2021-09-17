package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO12 {
    public  void doLongTimeMethod() {
        for (int i = 0; i < 50; i++) {
            System.out.println("threadName="+Thread.currentThread().getName()+", i="+i);
        }
        System.out.println("============");
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                System.out.println("threadName="+Thread.currentThread().getName()+", i="+i);
            }
        }
    }
}
