package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO16;
import com.thread.pojo.ThreadA16;
import com.thread.pojo.ThreadB16;

/**
 * synchronized(非this对象x)同步代码块
 * synchronized(非this对象x)与同步synchronized方法时异步调用的，持有的监听器不同。
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread16 {

    public static void main(String[] args) {
        SynchronizedThreadPO16 synchronizedThreadPO16 = new SynchronizedThreadPO16();
        ThreadA16 threadA16 = new ThreadA16(synchronizedThreadPO16);
        threadA16.setName("a");
        threadA16.start();
        ThreadB16 threadB16 = new ThreadB16(synchronizedThreadPO16);
        threadB16.setName("b");
        threadB16.start();
    }
}
