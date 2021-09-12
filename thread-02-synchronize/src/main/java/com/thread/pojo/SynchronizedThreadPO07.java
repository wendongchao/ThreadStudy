package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 18:09
 */
public class SynchronizedThreadPO07 {
    synchronized public void methodA() {
        System.out.println("methodA");
        methodB();
    }

    synchronized public void methodB() {
        System.out.println("methodB");
        methodC();
    }

    synchronized public void methodC() {
        System.out.println("methodC");
    }


}
