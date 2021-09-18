package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO15;
import com.thread.pojo.ThreadA15;
import com.thread.pojo.ThreadB15;

/**
 * synchronized(非this对象x)同步代码块
 * 使用 “synchronized(非this对象x)同步代码块” 格式进行同步操作时，对象监听器必须是同一个对象。
 * 如果不是同一个对象监听器，运行的结果就是异步调用了，就会交叉运行。
 * 示例：
 * 同一个监听器，同步执行
 * 不是同一个监听器，异步执行
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread15 {

    public static void main(String[] args) {
        SynchronizedThreadPO15 synchronizedThreadPO15 = new SynchronizedThreadPO15();
        ThreadA15 threadA15 = new ThreadA15(synchronizedThreadPO15);
        threadA15.start();
        ThreadB15 threadB15 = new ThreadB15(synchronizedThreadPO15);
        threadB15.start();
    }
}
