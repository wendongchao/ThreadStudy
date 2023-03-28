package com.thread.synchronize;

import com.thread.pojo.ThreadVolatile26;

/**
 * volatile：修饰变量，使线程间变量可见
 * 不保证原子性，只保证多个线程间的可见性
 * @auther: dongchao
 * @data: 2023/3/28 09:35
 */
public class SynchronizedThread26 {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatile26 volatile26 = new ThreadVolatile26();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(volatile26);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(1000);
        System.out.println("数值："+volatile26.getCount());

    }
}
