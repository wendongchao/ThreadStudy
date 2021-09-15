package com.thread.synchronize;

import com.thread.pojo.Sub08;

/**
 * synchronized同步方法
 * synchronized锁重入，支持父子继承
 * 说明：
 * 关键字synchronized拥有锁重入的功能，
 * 当一个线程得到一个对象锁后，再次请求次对象锁时是可以再次得到该对象的锁。
 * 一个synchronized方法/块的内部调用本类的其他synchronized方法/块时，是永远可以得到锁。
 * 当一个线程获取一个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的，
 * 如果不可锁重入的话，就会造成死锁。
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread08 extends Thread{

    @Override
    public void run() {
        Sub08 sub08 = new Sub08();
        sub08.methodB();
    }

    public static void main(String[] args) {
        SynchronizedThread08 synchronizedThread08 = new SynchronizedThread08();
        synchronizedThread08.start();
    }
}
