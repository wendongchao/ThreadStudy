package com.thread.base;

import com.thread.pojo.StopThreadObject;

/**
 * 停止线程
 * 强制停止线程：stop()，不推荐，
 * 强制停止线程会导致线程两个方面问题：
 * 1、不能完成一些清理性的工作。
 * 2、对锁定对象“解锁”，导致数据得不到同步处理，出现数据不一致问题。
 *
 * 数据不一致示例
 * @Author wendongchao
 * @Date 2021/9/9 0:05
 */
public class StopThread07 extends Thread{

    private StopThreadObject object;

    public StopThread07(StopThreadObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b","bb");
    }

    public static void main(String[] args) {
        try {
            StopThreadObject object = new StopThreadObject();
            StopThread07 thread = new StopThread07(object);
            thread.start();
            Thread.sleep(100);
            thread.stop();// 停止线程
            System.out.println(object.getName() + " " + object.getPassword());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
