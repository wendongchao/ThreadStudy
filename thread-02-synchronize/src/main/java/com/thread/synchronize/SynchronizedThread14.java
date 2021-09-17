package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO14;
import com.thread.pojo.ThreadA14;
import com.thread.pojo.ThreadB14;

/**
 * synchronized同步语句块
 * synchronized(this)：怎么证明代码块锁定的是当前对象呢？
 * 示例：
 * 从结果可以看出，当otherMethod方法没有关键字synchronized修饰时，两个线程是异步执行的
 * 当otherMethod方法有关键字synchronized修饰时，两个线程是同步执行的，
 * 所以synchronized(this)代码块锁定的是当前对象。
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread14 {

    public static void main(String[] args) {
        SynchronizedThreadPO14 synchronizedThreadPO14 = new SynchronizedThreadPO14();
        ThreadA14 threadA14 = new ThreadA14(synchronizedThreadPO14);
        threadA14.start();
        ThreadB14 threadB14 = new ThreadB14(synchronizedThreadPO14);
        threadB14.start();
    }
}
