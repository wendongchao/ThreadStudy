package com.thread.synchronize;


import com.thread.pojo.*;

/**
 * 静态同步synchronized方法与synchronized(this)代码块
 * 关键字synchronized还可以使用在static静态方法上，即对当前的class类进行加锁。
 * 关键字synchronized使用在普通方法上，对当前对象加锁，多个对象多个锁。
 * 示例：
 * 一个实例：异步的原因是持有不同的锁，一个是对象锁，另一个是class锁，而class锁可以对类的所有对象实例起作用。
 * 二个实例：多个实例，也会同步
 * @Author wendongchao
 * @Date 2121/9/11 21:55
 */
public class SynchronizedThread21 {

    public static void main(String[] args) throws InterruptedException {
        // 一个实例对象
//        SynchronizedThreadPO21 po21 = new SynchronizedThreadPO21();
//        ThreadA21 threadA21 = new ThreadA21(po21);
//        threadA21.setName("A");
//        threadA21.start();
//
//        ThreadB21 threadB21 = new ThreadB21(po21);
//        threadB21.setName("B");
//        threadB21.start();
//
//        ThreadC21 threadC21 = new ThreadC21(po21);
//        threadC21.setName("C");
//        threadC21.start();
        // 二个实例对象
        SynchronizedThreadPO21 po21a = new SynchronizedThreadPO21();
        SynchronizedThreadPO21 po21b = new SynchronizedThreadPO21();
        ThreadA21 threadA21 = new ThreadA21(po21a);
        threadA21.setName("A");
        threadA21.start();

        ThreadB21 threadB21 = new ThreadB21(po21b);
        threadB21.setName("B");
        threadB21.start();
    }
}
