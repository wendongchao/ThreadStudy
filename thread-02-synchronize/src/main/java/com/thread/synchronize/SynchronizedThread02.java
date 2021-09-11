package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO02;

/**
 * 线程同步
 * 多个线程访问一个对象中的实例变量，会出现线程不安全情况
 * 实例：
 * 两个线程访同时访问一个“没有同步”的方法，且操作的是一个个对象的实例变量，那么会出现“非线程安全”问题
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread02 {

    public static void main(String[] args) {
        final SynchronizedThreadPO02 suspendThreadPO = new SynchronizedThreadPO02();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                suspendThreadPO.addI("a");
            }
        };
        thread1.setName("a");
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                suspendThreadPO.addI("b");
            }
        };
        thread2.setName("b");
        thread2.start();

    }
}
