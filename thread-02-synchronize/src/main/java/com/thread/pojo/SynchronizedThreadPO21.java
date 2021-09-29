package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 20:09
 */
public class SynchronizedThreadPO21 {
    synchronized public static void methodA() {
        try {
            System.out.println("methodA begin time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("methodA end time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public static void methodB() {
        try {
            System.out.println("methodB begin time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("methodB end time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void methodC() {
        try {
            System.out.println("methodC begin time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("methodC end time="+System.currentTimeMillis()+", name="+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
