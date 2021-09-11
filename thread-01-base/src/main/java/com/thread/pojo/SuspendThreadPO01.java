package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 17:17
 */
public class SuspendThreadPO01 {

    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }

}
