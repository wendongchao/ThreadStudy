package com.thread.base;

/**
 * 停止线程
 * 在sleep()状态下停止线程：先interrupt()后sleep()
 * @Author wendongchao
 * @Date 2021/9/8 23:46
 */
public class StopThread05 extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("run catch，状态："+this.isInterrupted());// 进入catch语句，会清除停止状态, false，证明sleep结束后触发异常
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        StopThread04 thread = new StopThread04();
        thread.start();
        thread.interrupt();// 停止线程
        System.out.println("是否停止1?="+thread.isInterrupted());
        System.out.println("是否停止2?="+thread.isInterrupted());
        System.out.println("end");
    }

}
