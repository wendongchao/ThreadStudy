package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA05 extends Thread{

    private SynchronizedThreadPO05 synchronizedThreadPO05;

    public ThreadA05(SynchronizedThreadPO05 synchronizedThreadPO05) {
        this.synchronizedThreadPO05 = synchronizedThreadPO05;
    }

    @Override
    public void run() {
        synchronizedThreadPO05.methodA();
    }

}
