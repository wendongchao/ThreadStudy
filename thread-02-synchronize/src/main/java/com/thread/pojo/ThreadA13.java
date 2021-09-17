package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA13 extends Thread{

    private SynchronizedThreadPO13 synchronizedThreadPO13;

    public ThreadA13(SynchronizedThreadPO13 synchronizedThreadPO13) {
        this.synchronizedThreadPO13 = synchronizedThreadPO13;
    }

    @Override
    public void run() {
        synchronizedThreadPO13.methodA();
    }

}
