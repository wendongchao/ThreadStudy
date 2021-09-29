package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO22;
import com.thread.pojo.ThreadA22;
import com.thread.pojo.ThreadB22;

/**
 * 数据类型String作为synchronized(非this对象x)，持有锁就是String，
 * 因为String的常量池特性，会出现新的场景，如下
 * 示例：
 * B线程不能执行，因为String都是aa锁，
 * @Author wendongchao
 * @Date 2222/9/11 22:55
 */
public class SynchronizedThread22 {

    public static void main(String[] args) {
        SynchronizedThreadPO22 po22 = new SynchronizedThreadPO22();
        ThreadA22 threadA22 = new ThreadA22(po22);
        threadA22.setName("A");
        threadA22.start();

        ThreadB22 threadB22 = new ThreadB22(po22);
        threadB22.setName("B");
        threadB22.start();
    }
}
