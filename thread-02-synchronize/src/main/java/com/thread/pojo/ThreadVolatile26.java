package com.thread.pojo;

/**
 * @auther: dongchao
 * @data: 2023/3/28 09:48
 */
public class ThreadVolatile26 implements Runnable {
    private volatile int count;

    public void add() {
        for (int i = 0; i < 100; i++) {
            count++;
            System.out.println("thread-name="+Thread.currentThread().getName()+",count="+count);
        }
    }

    @Override
    public void run() {
        add();
    }

    public int getCount() {
        return count;
    }
}
