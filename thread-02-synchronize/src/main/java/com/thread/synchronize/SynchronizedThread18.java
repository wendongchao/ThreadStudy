package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO181;
import com.thread.pojo.SynchronizedThreadPO182;
import com.thread.pojo.ThreadA18;
import com.thread.pojo.ThreadB18;

/**
 * synchronized(非this对象x)，3个结论
 * 1、当多个线程同时执行synchronized(x){}同步代码块时呈同步效果。
 * 2、当其他线程执行x对象中synchronized同步方法时呈同步效果。
 * 3、当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果。
 * 注意：如果其他线程调用不加synchronized关键字的方法时，还是异步调用。
 * 结论1：当多个线程同时执行synchronized(x){}同步代码块时呈同步效果。
 * 示例：
 * 可以看到线程呈 “同步” 效果
 * 那么持有不同的 “对象监视器” 有什么效果?
 * 可以看到线程呈 “异步” 效果
 *
 * @Author wendongchao
 * @Date 2021/9/11 18:55
 */
public class SynchronizedThread18 {

    public static void main(String[] args) throws InterruptedException {
//        SynchronizedThreadPO181 po181 = new SynchronizedThreadPO181();
//        SynchronizedThreadPO182 po182 = new SynchronizedThreadPO182();
//        ThreadA18 threadA18 = new ThreadA18(po181,po182);
//        threadA18.setName("A");
//        threadA18.start();
//        ThreadB18 threadB18 = new ThreadB18(po181,po182);
//        threadB18.setName("B");
//        threadB18.start();
        // 持有不同的 “对象监视器”
        SynchronizedThreadPO181 po181 = new SynchronizedThreadPO181();
        SynchronizedThreadPO182 po182a = new SynchronizedThreadPO182();
        SynchronizedThreadPO182 po182b = new SynchronizedThreadPO182();
        ThreadA18 threadA18 = new ThreadA18(po181,po182a);
        threadA18.setName("A");
        threadA18.start();
        ThreadB18 threadB18 = new ThreadB18(po181,po182b);
        threadB18.setName("B");
        threadB18.start();
    }
}
