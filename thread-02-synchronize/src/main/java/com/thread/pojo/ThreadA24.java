package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2024/9/11 24:57
 */
public class ThreadA24 extends Thread{

    private SynchronizedThreadPO24 po24;

    public ThreadA24(SynchronizedThreadPO24 po24) {
        this.po24 = po24;
    }

    @Override
    public void run() {
        po24.runMethod();
    }

}
