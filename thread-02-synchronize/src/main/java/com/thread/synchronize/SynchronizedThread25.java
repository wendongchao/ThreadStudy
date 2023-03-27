package com.thread.synchronize;

import com.thread.pojo.ThreadDead;

/**
 * 线程死锁：不同线程在等待不可能释放的锁，从而导致所有任务都无法执行
 * @auther: dongchao
 * @data: 2023/3/27 16:50
 */
public class SynchronizedThread25 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDead threadDead = new ThreadDead();
        threadDead.setUsername("a");
        Thread thread01 = new Thread(threadDead);
        thread01.start();
        Thread.sleep(100);
        threadDead.setUsername("b");
        Thread thread02 = new Thread(threadDead);
        thread02.start();
    }
}
