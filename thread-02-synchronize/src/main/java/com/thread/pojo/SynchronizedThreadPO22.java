package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 20:09
 */
public class SynchronizedThreadPO22 {
    public static void method(String param) {
        try {
            synchronized (param) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
