package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO13;
import com.thread.pojo.ThreadA13;
import com.thread.pojo.ThreadB13;

/**
 * synchronized同步语句块
 * synchronized代码块间的同步性
 * 一个object中有一个synchronized代码块：
 * 线程只有访问这个synchronized代码块的时候同步，访问其他方法异步。锁对象object
 * 一个object中有两个synchronized代码块：
 * 线程访问一个synchronized代码块，拿到object锁对象，那么其他线程访问另一个synchronized代码块，
 * 就需要等待，因为synchronized代码块使用的“对象监视器”是同一个
 * 说明：
 * 在使用同步synchronized(this)代码块时需要注意的是，当一个线程访问object的一个synchronized(this)
 * 同步代码块时，其他线程对同一个object中所有其他synchronized(this)同步代码块的访问将被阻塞，这
 * 说明synchronized使用的 “对象监视器” 是一个。
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread13 {

    public static void main(String[] args) {
        SynchronizedThreadPO13 synchronizedThreadPO13 = new SynchronizedThreadPO13();
        ThreadA13 threadA13 = new ThreadA13(synchronizedThreadPO13);
        threadA13.setName("a");
        threadA13.start();
        ThreadB13 threadB13 = new ThreadB13(synchronizedThreadPO13);
        threadB13.setName("b");
        threadB13.start();
    }
}
