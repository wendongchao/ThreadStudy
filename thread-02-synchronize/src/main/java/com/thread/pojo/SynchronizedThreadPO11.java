package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO11 {
    private String getData1;
    private String getData2;
    public synchronized void doLongTimeMethod() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "处理数据返回值 1 threadName=" + Thread.currentThread().getName();
            getData2 = "处理数据返回值 2 threadName=" + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
