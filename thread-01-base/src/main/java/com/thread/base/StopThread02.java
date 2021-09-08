package com.thread.base;

/**
 * 停止多线程
 * 判断线程停止状态：this.isInterrupted()
 * this.interrupted()：测试当前线程是否已中断，会清除中断标志。（当前线程是指运行该方法的线程）
 * this.isInterrupted()：测试线程Thread对象是否中断，不会清除状态标志。
 * @author wendongchao
 * @ClassName StopThread02
 * @Date 2021/9/8 13:54
 */
public class StopThread02 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("线程名称："+Thread.currentThread().getName()+", i=" + i);
        }
    }

    public static void main(String[] args) {
        try {
            StopThread02 thread = new StopThread02();
            thread.start();
            Thread.sleep(5);
            thread.interrupt();// 停止线程
            System.out.println("是否停止1?="+thread.isInterrupted());// 测试线程Thread对象是否中断
            System.out.println("是否停止2?="+thread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
