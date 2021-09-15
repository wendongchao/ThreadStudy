package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA09 extends Thread{

    private SynchronizedThreadPO09 synchronizedThreadPO09;

    public ThreadA09(SynchronizedThreadPO09 synchronizedThreadPO09) {
        this.synchronizedThreadPO09 = synchronizedThreadPO09;
    }

    @Override
    public void run() {
        synchronizedThreadPO09.method();
    }

}
