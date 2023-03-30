package com.thread.waitnotify.pojo;

/**
 * @auther: dongchao
 * @data: 2023/3/30 11:38
 */
public class notifyTest05 {

    public void waitMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("wait begin " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("wait end " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("notify begin " + Thread.currentThread().getName());
                lock.notify();
                Thread.sleep(3000);
                System.out.println("notify end " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
