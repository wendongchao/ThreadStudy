package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO03;
import com.thread.pojo.ThreadA04;
import com.thread.pojo.ThreadB04;

/**
 * synchronized同步方法
 * 多个对象多个锁
 * 示例：
 * 两个线程分别访问同一个类的两个不同实例的相同名称的同步方法，效果是异步的方式运行
 * 关键字synchronized获取的锁都是对象锁
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread04 {

    public static void main(String[] args) {
        SynchronizedThreadPO03 suspendThreadPO1 = new SynchronizedThreadPO03();
        SynchronizedThreadPO03 suspendThreadPO2 = new SynchronizedThreadPO03();

        ThreadA04 thread1 = new ThreadA04(suspendThreadPO1);
        thread1.setName("a");
        thread1.start();

        ThreadB04 thread2 = new ThreadB04(suspendThreadPO2);
        thread2.setName("b");
        thread2.start();
    }
}
