package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB11 extends Thread{

    private SynchronizedThreadPO11 synchronizedThreadPO11;

    public ThreadB11(SynchronizedThreadPO11 synchronizedThreadPO11) {
        this.synchronizedThreadPO11 = synchronizedThreadPO11;
    }

    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        synchronizedThreadPO11.doLongTimeMethod();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }


}
