package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB14 extends Thread{

    private SynchronizedThreadPO14 synchronizedThreadPO14;

    public ThreadB14(SynchronizedThreadPO14 synchronizedThreadPO14) {
        this.synchronizedThreadPO14 = synchronizedThreadPO14;
    }

    @Override
    public void run() {
        synchronizedThreadPO14.otherMethod();
    }


}
