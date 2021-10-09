package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO23 {
   private String lock = "123";
   public void method() {
       try {
           synchronized (lock) {
               System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
               lock = "456";
               Thread.sleep(2000);
               System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
           }
       }catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
