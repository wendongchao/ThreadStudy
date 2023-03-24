package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 18:09
 */
public class SynchronizedThreadPO06 {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("A end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        try {
            System.out.println("begin methodB threadName=" + Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("B end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodC() {
        try {
            System.out.println("begin methodC threadName=" + Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("C end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
