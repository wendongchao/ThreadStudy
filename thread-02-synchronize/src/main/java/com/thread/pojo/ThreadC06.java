package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadC06 extends Thread{

    private SynchronizedThreadPO06 synchronizedThreadPO06;

    public ThreadC06(SynchronizedThreadPO06 synchronizedThreadPO06) {
        this.synchronizedThreadPO06 = synchronizedThreadPO06;
    }

    @Override
    public void run() {
        synchronizedThreadPO06.methodC();
    }


}
