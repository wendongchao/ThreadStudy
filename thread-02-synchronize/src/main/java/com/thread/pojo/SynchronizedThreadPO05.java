package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 18:09
 */
public class SynchronizedThreadPO05 {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
