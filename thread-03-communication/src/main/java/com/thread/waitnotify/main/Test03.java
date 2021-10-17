package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.Add;
import com.thread.waitnotify.pojo.Subtract;
import com.thread.waitnotify.pojo.ThreadA03;
import com.thread.waitnotify.pojo.ThreadB03;

/**
 * 等待wait的条件发生变化
 * 出现这样异常的原因是因为有两个实现删除remove()操作的线程，它们在Thread.sleep(100)；
 * 之前都执行了wait()方法，呈等待状态，当加操作的线程在0.1秒之后被运行时，通知了所有呈wait
 * 等待状态的减操作的线程，那么第一个实现减操作的线程能正确地删除list中的索引为0的数据，
 * 但第二个实现减操作的线程则出现索引溢出的异常，因为list中仅仅添加了一个数据，也只能删除一个数据，
 * 所以没有第二个数据可以删除。
 *
 * 在Subtract类的判断条件由if改变为while
 * @Author wendongchao
 * @Date 2021/10/17 17:16
 */
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadB03 threadB031 = new ThreadB03(subtract);
        threadB031.setName("sub 1");
        threadB031.start();

        ThreadB03 threadB032 = new ThreadB03(subtract);
        threadB032.setName("sub 2");
        threadB032.start();
        Thread.sleep(100);

        ThreadA03 threadA03 = new ThreadA03(add);
        threadA03.setName("add");
        threadA03.start();
    }
}
