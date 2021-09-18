package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO16 {
    private String anyStr = new String();
    public void methodA() {
        try {
            synchronized (anyStr) {
                System.out.println("a begin");
                Thread.sleep(100);
                System.out.println("a end");
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void methodB() {
        System.out.println("b begin");
        System.out.println("b end");
    }
}
