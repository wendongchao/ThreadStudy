package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO01;

/**
 * synchronized同步方法
 * 方法内的变量是线程同步的（线程安全）
 * “非线程安全”只存在“实例变量”中，方法内部是私有变量
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread01 {

    public static void main(String[] args) {
        final SynchronizedThreadPO01 suspendThreadPO = new SynchronizedThreadPO01();
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
