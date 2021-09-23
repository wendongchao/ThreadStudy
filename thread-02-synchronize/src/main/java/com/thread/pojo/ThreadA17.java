package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadA17 extends Thread{

    private SynchronizedThreadPO171 list;

    public ThreadA17(SynchronizedThreadPO171 list) {
        this.list = list;
    }

    @Override
    public void run() {
        SynchronizedThreadPO172 po172 = new SynchronizedThreadPO172();
        po172.addMethod(list, "A");
    }

}
