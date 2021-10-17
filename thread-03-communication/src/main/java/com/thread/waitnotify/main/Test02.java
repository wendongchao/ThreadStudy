package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.ThreadA02;
import com.thread.waitnotify.pojo.ThreadB02;

/**
 * 等待通知机制
 * wait end time在最后输出可以看出，notify方法执行后并不立刻释放锁，
 * 而是调用notify代码块执行完后释放锁
 *
 * 关键字synchronized可以将任何一个Object对象作为同步对象来看待，
 * 而java为每个Object都实现了wait()和notify()方法，它们必须用在被synchronized同步的Object的临界区内。
 * 通过调用wait()方法可以使处于临界区内的线程进入等待状态，同时释放被同步对象的锁。
 * 而notify操作可以唤醒一个因调用了wait操作而处于阻塞状态中的线程，使其进入就绪状态（runnable）。
 * 被重新唤醒的线程会试图重新获得临界区的控制权，也就是锁，并继续执行临界区内wait之后的代码。
 * 如果发出notify操作时没有处于阻塞状态中的线程，那么该命令会被忽略
 * @author wendongchao
 * @ClassName Test02
 * @Date 2021/10/11 17:18
 */
public class Test02 {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA02 threadA02 = new ThreadA02(lock);
            threadA02.start();
            Thread.sleep(50);

            ThreadB02 threadB02 = new ThreadB02(lock);
            threadB02.start();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
