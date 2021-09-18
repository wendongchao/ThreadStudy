package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA15 extends Thread{

    private SynchronizedThreadPO15 synchronizedThreadPO15;

    public ThreadA15(SynchronizedThreadPO15 synchronizedThreadPO15) {
        this.synchronizedThreadPO15 = synchronizedThreadPO15;
    }

    @Override
    public void run() {
        synchronizedThreadPO15.setValue("a", "aa");
    }

}
