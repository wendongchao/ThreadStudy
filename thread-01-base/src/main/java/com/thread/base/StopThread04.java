package com.thread.base;

/**
 * 停止线程
 * 在sleep()状态下停止线程：先sleep()后interrupt()
 * false，证明sleep结束后触发异常
 * 进入catch语句，会清除停止状态
 * @Author wendongchao
 * @Date 2021/9/8 23:31
 */
public class StopThread04 extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("run catch，状态："+this.isInterrupted());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            StopThread04 thread = new StopThread04();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();// 停止线程
            System.out.println("是否停止1?="+thread.isInterrupted());// false，证明sleep结束后触发异常
            System.out.println("是否停止2?="+thread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
