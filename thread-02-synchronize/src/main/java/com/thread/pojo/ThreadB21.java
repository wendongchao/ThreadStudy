package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB21 extends Thread{

    private SynchronizedThreadPO21 po21;

    public ThreadB21(SynchronizedThreadPO21 po21) {
        this.po21 = po21;
    }

    @Override
    public void run() {
       po21.methodB();
    }

}
