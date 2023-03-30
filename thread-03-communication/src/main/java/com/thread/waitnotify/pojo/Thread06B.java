package com.thread.waitnotify.pojo;

/**
 * @auther: dongchao
 * @data: 2023/3/30 15:46
 */
public class Thread06B extends Thread {
    private Pc06 pc06;
    public Thread06B(Pc06 pc06) {
        this.pc06 = pc06;
    }

    @Override
    public void run() {
        pc06.pop();
    }
}
