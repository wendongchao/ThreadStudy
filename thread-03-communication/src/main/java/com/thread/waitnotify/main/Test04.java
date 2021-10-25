package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.Consumer04;
import com.thread.waitnotify.pojo.Producer04;
import com.thread.waitnotify.pojo.ThreadA04;
import com.thread.waitnotify.pojo.ThreadB04;

/**
 * 生产者/消费者模式
 * 一生产与一消费：操作值
 * @author wendongchao
 * @ClassName Test04
 * @Date 2021/10/24 21:55
 */
public class Test04 {
    public static void main(String[] args) {
        String lock = new String("");
        Producer04 p = new Producer04(lock);
        Consumer04 c = new Consumer04(lock);
        ThreadA04 a04 = new ThreadA04(p);
        ThreadB04 b04 = new ThreadB04(c);
        a04.start();
        b04.start();

    }
}
