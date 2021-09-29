package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2121/9/11 22:57
 */
public class ThreadA21 extends Thread{

    private SynchronizedThreadPO21 po21;

    public ThreadA21(SynchronizedThreadPO21 po21) {
        this.po21 = po21;
    }

    @Override
    public void run() {
        po21.methodA();
    }

}
