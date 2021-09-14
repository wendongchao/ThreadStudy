package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO082;

/**
 * 线程同步
 * 出现异常，锁自动释放
 * 说明：
 *
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread09 extends Thread{

    @Override
    public void run() {
        SynchronizedThreadPO082 synchronizedThreadPO082 = new SynchronizedThreadPO082();
        synchronizedThreadPO082.methodB();
    }

    public static void main(String[] args) {
        SynchronizedThread09 synchronizedThread08 = new SynchronizedThread09();
        synchronizedThread08.start();
    }
}
