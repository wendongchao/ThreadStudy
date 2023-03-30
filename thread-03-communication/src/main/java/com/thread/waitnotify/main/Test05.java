package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.Thread05A;
import com.thread.waitnotify.pojo.Thread05B;

/**
 * notify方法执行后，不立即释放锁，需要等到安全区执行完，再释放锁
 *
 * @auther: dongchao
 * @data: 2023/3/30 11:27
 */
public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread05A thread05A = new Thread05A(lock);
        Thread threadA = new Thread(thread05A);
        threadA.start();
        Thread.sleep(1000);

        Thread05B thread05B = new Thread05B(lock);
        Thread threadB = new Thread(thread05B);
        threadB.start();
    }
}
