package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB18 extends Thread{

    private SynchronizedThreadPO181 po181;
    private SynchronizedThreadPO182 po182;

    public ThreadB18(SynchronizedThreadPO181 po181, SynchronizedThreadPO182 po182) {
        this.po181 = po181;
        this.po182 = po182;
    }

    @Override
    public void run() {
        po181.method(po182);
    }

}
