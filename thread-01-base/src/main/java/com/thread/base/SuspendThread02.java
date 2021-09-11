package com.thread.base;

import com.thread.pojo.SuspendThreadPO01;

/**
 * 暂停线程
 * 缺点
 * 使用suspend()和resume()暂停线程时，如果使用不当，极易造成公共的同步对象独占，使其他线程不能访问公共同步对象
 * @Author wendongchao
 * @Date 2021/9/11 17:16
 */
public class SuspendThread02 {

    public static void main(String[] args) {
        try {
            final SuspendThreadPO01 suspendThreadPO = new SuspendThreadPO01();
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    suspendThreadPO.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(100);

            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    System.out.println("thread2启动了，但进入不了printString()方法");
                    System.out.println("因为printString()方法被线程a锁定并永远suspend()暂停了");
                    suspendThreadPO.printString();
                }
            };
            thread2.start();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
