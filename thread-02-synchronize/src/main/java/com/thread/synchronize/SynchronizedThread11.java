package com.thread.synchronize;

import com.thread.pojo.*;

/**
 * synchronized同步语句块
 * synchronized方法的缺点：
 * 线程a获取对象锁，并执行一个长时间任务，那么线程b一直等待
 * 示例：
 * 两个线程争抢统一资源时
 * 线程A，线程B同时执行，线程A先获取锁，执行很长时间，线程B一直在等待，直到线程A执行完毕，线程B才执行
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread11 {

    public static void main(String[] args) {
        SynchronizedThreadPO11 synchronizedThreadPO11 = new SynchronizedThreadPO11();
        ThreadA11 threadA11 = new ThreadA11(synchronizedThreadPO11);
        threadA11.start();
        ThreadB11 threadB11 = new ThreadB11(synchronizedThreadPO11);
        threadB11.start();
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }
        System.out.println("begintime1="+CommonUtils.beginTime1);
        System.out.println("endtime1="+CommonUtils.endTime1);
        System.out.println("begintime2="+CommonUtils.beginTime2);
        System.out.println("endtime2="+CommonUtils.endTime2);
        System.out.println("耗时：" + (endTime - beginTime) / 1000);
    }
}
