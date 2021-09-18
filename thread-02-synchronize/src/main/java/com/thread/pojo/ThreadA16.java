package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA16 extends Thread{

    private SynchronizedThreadPO16 synchronizedThreadPO16;

    public ThreadA16(SynchronizedThreadPO16 synchronizedThreadPO16) {
        this.synchronizedThreadPO16 = synchronizedThreadPO16;
    }

    @Override
    public void run() {
        synchronizedThreadPO16.methodA();
    }

}
