package com.thread.waitnotify.pojo;

/**
 * @author wendongchao
 * @ClassName ThreadA01
 * @Date 2021/10/11 17:12
 */
public class ThreadB03 extends Thread {
    private Subtract s;
    public ThreadB03(Subtract s) {
        this.s = s;
    }

    @Override
    public void run() {
       s.subtract();
    }
}
