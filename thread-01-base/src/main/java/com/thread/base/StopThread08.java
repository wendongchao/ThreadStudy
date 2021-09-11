package com.thread.base;

import com.thread.pojo.StopThreadObject;

/**
 * 停止线程
 * interrupt()与return结合停止线程suspend
 * @Author wendongchao
 * @Date 2021/9/11 9:07
 */
public class StopThread08 extends Thread{

    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("thread interrupt");
                return;
            }
            System.out.println("time="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        try {
            StopThread08 thread = new StopThread08();
            thread.start();
            Thread.sleep(1);
            thread.interrupt();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
