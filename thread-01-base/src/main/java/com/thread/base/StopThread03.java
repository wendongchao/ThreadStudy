package com.thread.base;

/**
 * 停止线程
 * 异常法：抛出异常，（推荐）
 * 因为在catch快中可以将异常向上抛，使线程停止的事件得以传播
 * this.interrupted()：测试当前线程是否已中断，会清除中断标志。（当前线程是指运行该方法的线程）
 * this.isInterrupted()：测试线程Thread对象是否中断，不会清除状态标志。
 * @Author wendongchao
 * @Date 2021/9/8 21:49
 */
public class StopThread03 extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500; i++) {
                if (this.isInterrupted()) {
                    System.out.println("进入停止状态");
                    throw new InterruptedException();
                }
                System.out.println("线程名称："+Thread.currentThread().getName()+", i=" + i);
            }
            System.out.println("for循环结束");
        } catch (InterruptedException e) {
            System.out.println("run catch");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            StopThread03 thread = new StopThread03();
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
