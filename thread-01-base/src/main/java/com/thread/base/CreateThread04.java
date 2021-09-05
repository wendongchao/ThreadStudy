package com.thread.base;

/**
 * 线程安全
 * 线程共享数据，多个线程访问同一个对象中同一个变量
 * @Author wendongchao
 * @Date 2021/9/5 23:51
 */
public class CreateThread04 extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("线程名称："+Thread.currentThread().getName()+",count="+count);
    }

    public static void main(String[] args) {
        CreateThread04 thread = new CreateThread04();
        Thread a = new Thread(thread,"A");
        Thread b = new Thread(thread,"B");
        Thread c = new Thread(thread,"C");
        Thread d = new Thread(thread,"D");
        Thread e = new Thread(thread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
