package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2022/9/11 22:57
 */
public class ThreadB22 extends Thread{

    private SynchronizedThreadPO22 po22;

    public ThreadB22(SynchronizedThreadPO22 po22) {
        this.po22 = po22;
    }

    @Override
    public void run() {
        po22.method("aa");
    }

}
