package com.thread.pojo;

import com.thread.pojo.SynchronizedThreadPO03;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA04 extends Thread{

    private SynchronizedThreadPO03 synchronizedThreadPO03;

    public ThreadA04(SynchronizedThreadPO03 synchronizedThreadPO03) {
        this.synchronizedThreadPO03 = synchronizedThreadPO03;
    }

    @Override
    public void run() {
        synchronizedThreadPO03.addI("a");
    }

}
