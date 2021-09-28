package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO191;
import com.thread.pojo.SynchronizedThreadPO192;
import com.thread.pojo.ThreadA19;
import com.thread.pojo.ThreadB19;

/**
 * synchronized(非this对象x)，3个结论
 * 1、当多个线程同时执行synchronized(x){}同步代码块时呈同步效果。
 * 2、当其他线程执行x对象中synchronized同步方法时呈同步效果。
 * 3、当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果。
 * 注意：如果其他线程调用不加synchronized关键字的方法时，还是异步调用。
 * 结论3：当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果。
 * 示例：
 * 可以看到线程呈 “同步” 效果
 *
 * @Author wendongchao
 * @Date 2021/9/11 19:55
 */
public class SynchronizedThread20 {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedThreadPO191 po191 = new SynchronizedThreadPO191();
        SynchronizedThreadPO192 po192 = new SynchronizedThreadPO192();
        ThreadA19 threadA19 = new ThreadA19(po191,po192);
        threadA19.setName("A");
        threadA19.start();
        Thread.sleep(100);
        ThreadB19 threadB19 = new ThreadB19(po192);
        threadB19.setName("B");
        threadB19.start();
    }
}
