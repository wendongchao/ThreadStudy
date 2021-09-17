package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO13 {
    public  void methodA() {
       try {
           synchronized (this) {
               System.out.println("a begin time="+System.currentTimeMillis());
               Thread.sleep(100);
               System.out.println("a end time="+System.currentTimeMillis());
           }
       }catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
    public void methodB() {
        synchronized (this) {
            System.out.println("b begin time="+System.currentTimeMillis());
            System.out.println("b end time="+System.currentTimeMillis());
        }
    }
}
