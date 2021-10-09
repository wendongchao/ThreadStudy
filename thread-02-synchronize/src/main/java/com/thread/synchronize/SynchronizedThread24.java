package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO24;
import com.thread.pojo.ThreadA24;
import com.thread.pojo.ThreadB24;

import javax.sound.midi.Soundbank;

/**
 * 锁对象改变
 * 在将任何数据类型作为同步锁时，需要注意的是，是否有多个线程同时持有锁对象，
 * 如果同时持有相同的锁对象，则这些线程之间就是同步的；如果分别获取锁对象，这些线程之间就是异步的。
 * 示例：
 * 在没有添加关键字synchronized之前，线程A,B的数据值是不可见的，
 * 添加关键字synchronized后，因为关键字synchronized具有两个特性：互斥性和可见性，
 * 所以线程A看到了线程B修改的数据，保持了线程的可见性
 * @Author wendongchao
 * @Date 2424/9/11 24:55
 */
public class SynchronizedThread24 {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedThreadPO24 po24 = new SynchronizedThreadPO24();
        ThreadA24 threadA24 = new ThreadA24(po24);
        threadA24.setName("A");
        threadA24.start();
        Thread.sleep(1000);

        ThreadB24 threadB24 = new ThreadB24(po24);
        threadB24.setName("B");
        threadB24.start();

        System.out.println("已经发起停止命令");
    }
}
