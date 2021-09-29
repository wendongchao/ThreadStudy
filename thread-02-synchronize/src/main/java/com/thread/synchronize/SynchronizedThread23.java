package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO22;
import com.thread.pojo.ThreadA22;
import com.thread.pojo.ThreadB22;

/**
 * 锁对象改变
 * @Author wendongchao
 * @Date 2222/9/11 22:55
 */
public class SynchronizedThread23 {

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
