package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB15 extends Thread{

    private SynchronizedThreadPO15 synchronizedThreadPO15;

    public ThreadB15(SynchronizedThreadPO15 synchronizedThreadPO15) {
        this.synchronizedThreadPO15 = synchronizedThreadPO15;
    }

    @Override
    public void run() {
        synchronizedThreadPO15.setValue("b", "bb");
    }


}
