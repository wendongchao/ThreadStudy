package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO201;
import com.thread.pojo.SynchronizedThreadPO202;
import com.thread.pojo.ThreadA20;
import com.thread.pojo.ThreadB20;

/**
 * synchronized(非this对象x)，3个结论
 * 1、当多个线程同时执行synchronized(x){}同步代码块时呈同步效果。
 * 2、当其他线程执行x对象中synchronized同步方法时呈同步效果。
 * 3、当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果。
 * 注意：如果其他线程调用不加synchronized关键字的方法时，还是异步调用。
 * 结论3：当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果。
 * 示例：
 * 可以看到线程呈 “同步” 效果
 *
 * @Author wendongchao
 * @Date 2021/9/11 20:55
 */
public class SynchronizedThread20 {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedThreadPO201 po201 = new SynchronizedThreadPO201();
        SynchronizedThreadPO202 po202 = new SynchronizedThreadPO202();
        ThreadA20 threadA20 = new ThreadA20(po201,po202);
        threadA20.setName("A");
        threadA20.start();
        Thread.sleep(100);
        ThreadB20 threadB20 = new ThreadB20(po202);
        threadB20.setName("B");
        threadB20.start();
    }
}
