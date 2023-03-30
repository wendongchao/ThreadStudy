package com.thread.waitnotify.pojo;

/**
 * @auther: dongchao
 * @data: 2023/3/30 15:46
 */
public class Thread06A extends Thread {
    private Pc06 pc06;
    public Thread06A(Pc06 pc06) {
        this.pc06 = pc06;
    }

    @Override
    public void run() {
        pc06.push();
    }
}
