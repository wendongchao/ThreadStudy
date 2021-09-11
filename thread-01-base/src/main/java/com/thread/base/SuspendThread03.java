package com.thread.base;

import com.thread.pojo.SuspendThreadPO02;

/**
 * 暂停线程
 * 缺点
 * 数据不同步
 * @Author wendongchao
 * @Date 2021/9/11 17:38
 */
public class SuspendThread03 {

    public static void main(String[] args) {
        try {
            final SuspendThreadPO02 suspendThreadPO = new SuspendThreadPO02();
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    suspendThreadPO.setValue("a","aa");
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(100);

            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    suspendThreadPO.printString();
                }
            };
            thread2.start();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
