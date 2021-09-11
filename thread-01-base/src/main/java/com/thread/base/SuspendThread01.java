package com.thread.base;

import lombok.Data;

/**
 * 暂停线程
 * 线程还可以再运行
 * suspend():暂停线程，resume()：恢复线程
 * @Author wendongchao
 * @Date 2021/9/11 16:47
 */
@Data
public class SuspendThread01 extends Thread{
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }

    public static void main(String[] args) {
        try {
            SuspendThread01 thread = new SuspendThread01();
            thread.start();
            Thread.sleep(100);
            // a
            thread.suspend();
            System.out.println("a="+System.currentTimeMillis()+", i="+thread.getI());
            Thread.sleep(100);
            System.out.println("a="+System.currentTimeMillis()+", i="+thread.getI());

            // b
            thread.resume();
            Thread.sleep(100);

            // c
            thread.suspend();
            System.out.println("b="+System.currentTimeMillis()+", i="+thread.getI());
            Thread.sleep(100);
            System.out.println("b="+System.currentTimeMillis()+", i="+thread.getI());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
