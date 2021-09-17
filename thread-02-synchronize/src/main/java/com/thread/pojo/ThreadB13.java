package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB13 extends Thread{

    private SynchronizedThreadPO13 synchronizedThreadPO13;

    public ThreadB13(SynchronizedThreadPO13 synchronizedThreadPO13) {
        this.synchronizedThreadPO13 = synchronizedThreadPO13;
    }

    @Override
    public void run() {
        synchronizedThreadPO13.methodB();
    }


}
