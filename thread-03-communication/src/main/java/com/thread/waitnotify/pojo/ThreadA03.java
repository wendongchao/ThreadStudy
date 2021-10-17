package com.thread.waitnotify.pojo;

/**
 * @author wendongchao
 * @ClassName ThreadA01
 * @Date 2021/10/11 17:12
 */
public class ThreadA03 extends Thread {
    private Add a;
    public ThreadA03(Add a) {
        this.a = a;
    }

    @Override
    public void run() {
       a.add();
    }
}
