package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB20 extends Thread{
    
    private SynchronizedThreadPO202 po202;

    public ThreadB20(SynchronizedThreadPO202 po202) {
        this.po202 = po202;
    }

    @Override
    public void run() {
        po202.printStr();
    }

}
