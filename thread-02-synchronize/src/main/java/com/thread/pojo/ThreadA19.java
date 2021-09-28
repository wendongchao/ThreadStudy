package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA19 extends Thread{

    private SynchronizedThreadPO191 po191;
    private SynchronizedThreadPO192 po192;

    public ThreadA19(SynchronizedThreadPO191 po191, SynchronizedThreadPO192 po192) {
        this.po191 = po191;
        this.po192 = po192;
    }

    @Override
    public void run() {
        po191.method(po192);
    }

}
