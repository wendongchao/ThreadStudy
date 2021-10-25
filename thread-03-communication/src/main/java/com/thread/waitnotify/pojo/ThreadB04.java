package com.thread.waitnotify.pojo;

/**
 * @author wendongchao
 * @ClassName ThreadA01
 * @Date 2021/10/11 17:12
 */
public class ThreadB04 extends Thread {
    private Consumer04 c;
    public ThreadB04(Consumer04 c) {
        this.c = c;
    }

    @Override
    public void run() {
       c.getValue();
    }
}
