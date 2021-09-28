package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB19 extends Thread{
    
    private SynchronizedThreadPO192 po192;

    public ThreadB19(SynchronizedThreadPO192 po192) {
        this.po192 = po192;
    }

    @Override
    public void run() {
        po192.printStr();
    }

}
