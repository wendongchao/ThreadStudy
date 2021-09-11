package com.thread.pojo;


/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB04 extends Thread{

    private SynchronizedThreadPO03 synchronizedThreadPO03;

    public ThreadB04(SynchronizedThreadPO03 synchronizedThreadPO03) {
        this.synchronizedThreadPO03 = synchronizedThreadPO03;
    }

    @Override
    public void run() {
        synchronizedThreadPO03.addI("b");
    }


}
