package com.thread.synchronize;

import com.thread.pojo.SynchronizedThreadPO05;
import com.thread.pojo.ThreadA05;
import com.thread.pojo.ThreadB05;

/**
 * synchronized同步方法
 * synchronized方法与锁对象
 * 关键字synchronized获取的锁都是对象锁
 * 示例：
 * synchronized修饰的是方法，当synchronized修饰方法，和不修饰方法，
 * 可以看到修饰方法：获取的锁是对象，这个对象在共享的情况下，顺序输出
 * 不修饰方法：线程访问的不是共享资源，不存在竞争排队的情况，
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread05 {

    public static void main(String[] args) {
        SynchronizedThreadPO05 suspendThreadPO1 = new SynchronizedThreadPO05();

        ThreadA05 thread1 = new ThreadA05(suspendThreadPO1);
        thread1.setName("a");
        thread1.start();

        ThreadB05 thread2 = new ThreadB05(suspendThreadPO1);
        thread2.setName("b");
        thread2.start();
    }
}
