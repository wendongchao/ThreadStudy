package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.ThreadA01;
import com.thread.waitnotify.pojo.ThreadB01;

/**
 * 等待通知机制
 * 线程调用wait()方法，进入等待状态，并释放锁，
 * 线程执行notify()代码块后，通知wait状态的线程，进入准备阶段Runnable
 * 示例：
 * 线程进入wait状态后1秒后被notify唤醒
 * @author wendongchao
 * @ClassName Test01
 * @Date 2021/10/11 17:18
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA01 threadA01 = new ThreadA01(lock);
            threadA01.start();
            Thread.sleep(1000);

            ThreadB01 threadB01 = new ThreadB01(lock);
            threadB01.start();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
