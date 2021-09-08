package com.thread.base;

/**
 * 停止多线程
 * 判断线程停止状态：this.interrupted()
 * this.interrupted()：测试当前线程是否已中断，会清除中断标志。（当前线程是指运行该方法的线程）
 * this.isInterrupted()：测试线程Thread对象是否中断，不会清除状态标志。
 * @author wendongchao
 * @ClassName StopThread01
 * @Date 2021/9/6 16:46
 */
public class StopThread01 extends Thread{

    // 1. 新建一个类继承 Thread 类，并重写 Thread 类的 run() 方法。
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("线程名称："+Thread.currentThread().getName()+", i=" + i);
        }
    }

    public static void main(String[] args) {
        try {
            // 2. 创建 Thread 子类的实例。
            StopThread01 thread = new StopThread01();
            // 3. 调用该子类实例的 start() 方法启动该线程。
            thread.start();
            thread.sleep(10);
            Thread.currentThread().interrupt();
            System.out.println("是否停止1?="+Thread.interrupted());
            System.out.println("是否停止2?="+Thread.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
