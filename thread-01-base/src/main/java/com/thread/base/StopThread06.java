package com.thread.base;

/**
 * 停止线程
 * 强制停止线程：stop()，不推荐，
 * 强制停止线程会导致线程两个方面问题：
 * 1、不能完成一些清理性的工作。
 * 2、对锁定对象“解锁”，导致数据得不到同步处理，出现数据不一致问题。
 * @Author wendongchao
 * @Date 2021/9/8 23:52
 */
public class StopThread06 extends Thread{
    private int i = 0;

    @Override
    public void run() {
        try {
           while (true) {
               i++;
               System.out.println("i="+i);
               Thread.sleep(100);
           }
        } catch (InterruptedException e) {
            System.out.println("run catch，状态："+this.isInterrupted());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            StopThread06 thread = new StopThread06();
            thread.start();
            Thread.sleep(1000);
            thread.stop();// 停止线程
            System.out.println("是否停止1?="+thread.isInterrupted());
            System.out.println("是否停止2?="+thread.isInterrupted());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
