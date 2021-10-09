package com.thread.synchronize;


import com.thread.pojo.SynchronizedThreadPO23;
import com.thread.pojo.ThreadA23;
import com.thread.pojo.ThreadB23;

/**
 * synchronized代码块有volatile同步的功能
 * 关键字synchronized可以使多个线程访问同一个资源具有同步性，而且它还具有将线程工作
 * 内存中的私有变量与公共内存中的变量同步的功能
 * @Author wendongchao
 * @Date 2323/9/11 23:55
 */
public class SynchronizedThread23 {

    public static void main(String[] args) throws InterruptedException {
        // 情况1:50毫秒后线程B取得的锁时“456”
//        SynchronizedThreadPO23 po23 = new SynchronizedThreadPO23();
//        ThreadA23 threadA23 = new ThreadA23(po23);
//        threadA23.setName("A");
//        threadA23.start();
//
//        ThreadB23 threadB23 = new ThreadB23(po23);
//        threadB23.setName("B");
//        Thread.sleep(50);
//        threadB23.start();

        // 情况2：线程A和B持有的锁都是“123”，虽然将锁改成了“456”，但结果还是同步的，
        // 因为A和B共同争抢的锁时“123”
        // 这就说明了：只要对象不变，即使对象的属性被改变，运行的结构还是同步。
        SynchronizedThreadPO23 po23 = new SynchronizedThreadPO23();
        ThreadA23 threadA23 = new ThreadA23(po23);
        threadA23.setName("A");
        threadA23.start();

        ThreadB23 threadB23 = new ThreadB23(po23);
        threadB23.setName("B");
        threadB23.start();
    }
}
