package com.thread.waitnotify.pojo;

/**
 * @auther: dongchao
 * @data: 2023/3/30 15:35
 */
public class Pc06 {
    private volatile Boolean isActive = true;
    private Object lock;
    public Pc06(Object lock) {
        this.lock = lock;
    }

    public void push() {
        try {
            synchronized (lock) {
                while (!isActive) {
                    lock.wait();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("添加参数信息push");
                }
                isActive = false;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pop() {
        try {
            synchronized (lock) {
                while (isActive) {
                    lock.wait();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("弹出参数信息pop");
                }
                isActive = true;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
