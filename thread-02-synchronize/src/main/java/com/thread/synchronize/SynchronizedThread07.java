package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO06;
import com.thread.pojo.SynchronizedThreadPO07;
import com.thread.pojo.ThreadA06;
import com.thread.pojo.ThreadB06;

/**
 * 线程同步
 * synchronized锁重入
 * 说明：
 * 关键字synchronized拥有锁重入的功能，
 * 当一个线程得到一个对象锁后，再次请求次对象锁时是可以再次得到该对象的锁。
 * 一个synchronized方法/块的内部调用本类的其他synchronized方法/块时，是永远可以得到锁。
 * 当一个线程获取一个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的，
 * 如果不可锁重入的话，就会造成死锁。
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread07 extends Thread{

    @Override
    public void run() {
        SynchronizedThreadPO07 synchronizedThreadPO07 = new SynchronizedThreadPO07();
        synchronizedThreadPO07.methodA();
    }

    public static void main(String[] args) {
        SynchronizedThread07 synchronizedThread07 = new SynchronizedThread07();
        synchronizedThread07.start();
    }
}
