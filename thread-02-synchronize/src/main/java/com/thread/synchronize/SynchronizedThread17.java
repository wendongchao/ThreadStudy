package com.thread.synchronize;


import com.thread.pojo.*;

/**
 * synchronized(非this对象x)同步代码块
 * 同步代码块放到非同步synchronized方法中进行声明，并不能保证调用方法的线程的执行同步/顺序性,
 * 也就是线程调用方法的顺序是无序的，虽然在同步块中执行的顺序是同步的，这样极易出现 “ 脏读 ” 问题。
 *
 * 出现了脏读，出现的原因是两个线程以异步的方式返回list（同步方法）参数的大小，解决的方法是“同步化”
 * 在非同步调用同步方法时，进行同步化
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread17 {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedThreadPO171 po171 = new SynchronizedThreadPO171();
        ThreadA17 threadA17 = new ThreadA17(po171);
        threadA17.setName("A");
        threadA17.start();
        ThreadB17 threadB17 = new ThreadB17(po171);
        threadB17.setName("B");
        threadB17.start();
        Thread.sleep(100);
        System.out.println(po171.getSize());
    }
}
