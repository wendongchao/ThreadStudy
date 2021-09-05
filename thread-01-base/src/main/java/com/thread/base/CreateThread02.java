package com.thread.base;

/**
 * 创建线程
 * 实现Runnable创建线程
 * @Author wendongchao
 * @Date 2021/9/5 14:30
 */
public class CreateThread02 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程名称："+Thread.currentThread().getName());
        }
    }

    // 实现Runnable接口，Runnable需要先重写run方法，之后再调用Thread的start方法
    public static void main(String[] args) {
        CreateThread02 runnable = new CreateThread02();
        // 在Thread构造方法中放入实现Runnable的实例对象
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
