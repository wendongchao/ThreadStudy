package com.thread.waitnotify.pojo;

/**
 * @auther: dongchao
 * @data: 2023/3/30 11:30
 */
public class Thread05A implements Runnable {
    private Object lock;

    public Thread05A(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        notifyTest05 notifyTest05 = new notifyTest05();
        notifyTest05.waitMethod(lock);
    }
}
