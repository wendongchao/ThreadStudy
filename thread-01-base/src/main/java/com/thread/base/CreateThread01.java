package com.thread.base;

/**
 * 创建线程
 * 继承Thread创建线程
 * @Author wendongchao
 * @Date 2021/9/5 13:56
 */
public class CreateThread01 extends Thread {

    // 1. 新建一个类继承 Thread 类，并重写 Thread 类的 run() 方法。
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程名称："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // 2. 创建 Thread 子类的实例。
        CreateThread01 threadDemo = new CreateThread01();
        // 3. 调用该子类实例的 start() 方法启动该线程。
        threadDemo.start();
    }
}
