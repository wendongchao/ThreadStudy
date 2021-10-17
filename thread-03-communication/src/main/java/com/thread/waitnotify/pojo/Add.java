package com.thread.waitnotify.pojo;

/**
 * @Author wendongchao
 * @Date 2021/10/17 17:19
 */
public class Add {
    private String lock;
    public Add(String lock) {
        this.lock = lock;
    }
    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
