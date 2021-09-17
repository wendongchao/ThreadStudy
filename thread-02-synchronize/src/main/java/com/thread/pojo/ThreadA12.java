package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA12 extends Thread{

    private SynchronizedThreadPO12 synchronizedThreadPO12;

    public ThreadA12(SynchronizedThreadPO12 synchronizedThreadPO12) {
        this.synchronizedThreadPO12 = synchronizedThreadPO12;
    }

    @Override
    public void run() {
        synchronizedThreadPO12.doLongTimeMethod();
    }

}
