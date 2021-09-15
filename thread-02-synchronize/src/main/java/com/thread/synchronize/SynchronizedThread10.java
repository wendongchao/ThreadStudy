package com.thread.synchronize;

import com.thread.pojo.*;

/**
 * synchronized同步方法
 * 同步不具有继承性
 * 说明：
 * 父类方法有关键字synchronized修饰，子类方法没有，子类方法调用父类方法:
 * 那么多线程访问子类方法时，是异步访问的，只有访问父类方法时，获取锁对象（子类对象），才同步执行
 * 父类方法有关键字synchronized修饰，子类方法有关键字synchronized修饰，子类方法调用父类方法:
 * 那么多线程访问子类方法时，是同步访问的（子类对象锁），访问父类方法时，获取锁对象（子类对象），同步执行。
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread10 {

    public static void main(String[] args) {
        Sub10 sub10 = new Sub10();
        ThreadA10 threadA10 = new ThreadA10(sub10);
        threadA10.setName("a");
        threadA10.start();
        ThreadB10 threadB10 = new ThreadB10(sub10);
        threadB10.setName("b");
        threadB10.start();
    }
}
