package com.thread.base;

/**
 * 线程安全
 * 线程不共享数据，每个线程操作自己的数据
 * @Author wendongchao
 * @Date 2021/9/5 23:51
 */
public class CreateThread03 extends Thread {
    private int count = 5;

    public CreateThread03(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("线程名称："+Thread.currentThread().getName()+",count="+count);
        }
    }

    public static void main(String[] args) {
        CreateThread03 a = new CreateThread03("A");
        CreateThread03 b = new CreateThread03("B");
        CreateThread03 c = new CreateThread03("C");
        a.start();
        b.start();
        c.start();
    }
}
