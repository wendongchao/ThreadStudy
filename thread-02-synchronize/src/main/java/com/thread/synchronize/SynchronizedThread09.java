package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO09;
import com.thread.pojo.ThreadA09;
import com.thread.pojo.ThreadB09;

/**
 * synchronized同步方法
 * 出现异常，锁自动释放
 * 说明：
 * 线程a出现异常并释放锁，线程b进入方法正常打印
 * 所以出现异常的锁被自动释放了。
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread09 {

    public static void main(String[] args) {
        try {
            SynchronizedThreadPO09 synchronizedThreadPO09 = new SynchronizedThreadPO09();
            ThreadA09 threadA09 = new ThreadA09(synchronizedThreadPO09);
            threadA09.setName("a");
            threadA09.start();
            Thread.sleep(500);
            ThreadB09 threadB09 = new ThreadB09(synchronizedThreadPO09);
            threadB09.setName("b");
            threadB09.start();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
