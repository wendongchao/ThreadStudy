package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO12;
import com.thread.pojo.ThreadA12;
import com.thread.pojo.ThreadB12;

/**
 * synchronized同步语句块
 * 一半同步，一半异步
 * 不在synchronized块中异步执行，在synchronized块中同步执行。
 * 示例：
 * 两个线程访问一个对象的方法，方法中有同步代码块，那么
 * 访问synchronized (this)时，是同步，访问其他逻辑异步，
 * synchronized (this)：锁对象this，是当前对象
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread12 {

    public static void main(String[] args) {
        SynchronizedThreadPO12 synchronizedThreadPO12 = new SynchronizedThreadPO12();
        ThreadA12 threadA12 = new ThreadA12(synchronizedThreadPO12);
        threadA12.start();
        ThreadB12 threadB12 = new ThreadB12(synchronizedThreadPO12);
        threadB12.start();
    }
}
