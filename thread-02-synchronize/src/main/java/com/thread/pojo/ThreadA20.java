package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA20 extends Thread{

    private SynchronizedThreadPO201 po201;
    private SynchronizedThreadPO202 po202;

    public ThreadA20(SynchronizedThreadPO201 po201, SynchronizedThreadPO202 po202) {
        this.po201 = po201;
        this.po202 = po202;
    }

    @Override
    public void run() {
        po201.method(po202);
    }

}
