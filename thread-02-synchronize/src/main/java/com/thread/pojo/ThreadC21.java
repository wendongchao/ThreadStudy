package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadC21 extends Thread{

    private SynchronizedThreadPO21 po21;

    public ThreadC21(SynchronizedThreadPO21 po21) {
        this.po21 = po21;
    }

    @Override
    public void run() {
        po21.methodC();
    }

}
