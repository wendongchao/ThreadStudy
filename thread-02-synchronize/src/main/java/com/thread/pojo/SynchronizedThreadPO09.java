package com.thread.pojo;


/**
 * @Author wendongchao
 * @Date 2021/9/11 18:09
 */
public class SynchronizedThreadPO09 {
    synchronized public void method(){
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("threadName:"+Thread.currentThread().getName() + "time:"+System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0,8).equals("0.123456")) {
                    System.out.println("threadName:"+Thread.currentThread().getName() + "time:"+System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }else {
            System.out.println("thread B run time:"+System.currentTimeMillis());
        }
    }

}
