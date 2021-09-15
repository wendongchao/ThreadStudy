package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO03;

/**
 * synchronized同步方法
 * 多个线程访问一个对象中的同步方法时，一定是线程安全的，及时使用到了实例变量
 * 实例：
 * 多个线程访问一个对象中的同步方法时，一定是线程安全的。实例是同步访问，线程会顺序输出
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread03 {

    public static void main(String[] args) {
        final SynchronizedThreadPO03 suspendThreadPO = new SynchronizedThreadPO03();
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
