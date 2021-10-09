package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2023/9/11 23:57
 */
public class ThreadB23 extends Thread{

    private SynchronizedThreadPO23 po23;

    public ThreadB23(SynchronizedThreadPO23 po23) {
        this.po23 = po23;
    }

    @Override
    public void run() {
        po23.method();
    }

}
