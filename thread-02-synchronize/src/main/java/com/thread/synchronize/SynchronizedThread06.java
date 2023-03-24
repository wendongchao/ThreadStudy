package com.thread.synchronize;

import com.thread.pojo.*;

/**
 * synchronized同步方法
 * synchronized方法与锁对象
 * 关键字synchronized获取的锁都是对象锁
 * 示例：
 * 两个线程访问同一个对象的两个同步方法（不同步方法）
 * 不同步方法：methodB与methodA是异步方式运行的
 * 同步方法：methodB与methodA是同步方式运行的，谁在前先运行谁
 * 结论：
 * 1、A线程先持有object对象的lock锁，B线程可以以异步方式调用object对象中非synchronized类型的方法。
 * 2、A线程先持有object对象的lock锁，B线程调用object对象中synchronized类型的方法时需等待，也就是同步。
 * 脏读：
 * 两个线程访问同一个对象的两个同步方法（不同步方法）
 * 访问分为两种：set，get，两者都需要同步，
 * 情况1：synchronized修饰methodA，methodB没有修饰，如果methodA,methodB都对实例变量进行操作，
 * 那么多线程调用methodA，methodB时（操作实例变量），会出现非线程安全问题
 * 情况2：synchronized修饰methodA，methodB，那么多线程调用methodB时（操作实例变量），必须等待methodA释放对象锁
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread06 {

    public static void main(String[] args) {
        SynchronizedThreadPO06 suspendThreadPO1 = new SynchronizedThreadPO06();

        ThreadA06 thread1 = new ThreadA06(suspendThreadPO1);
        thread1.setName("a");
        thread1.start();

        ThreadB06 thread2 = new ThreadB06(suspendThreadPO1);
        thread2.setName("b");
        thread2.start();

        ThreadC06 thread3 = new ThreadC06(suspendThreadPO1);
        thread3.setName("c");
        thread3.start();
    }
}
