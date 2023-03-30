package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.Pc06;
import com.thread.waitnotify.pojo.Thread06A;
import com.thread.waitnotify.pojo.Thread06B;

/**
 * 等待通知交替打印
 * @auther: dongchao
 * @data: 2023/3/30 15:35
 */
public class Test06 {
    public static void main(String[] args) {
        Object lock = new Object();
        Pc06 pc06 = new Pc06(lock);// 同一操作层面
        for (int i = 0; i < 20; i++) {
//            Pc06 pc06 = new Pc06(lock);// 多个操作层面
            Thread06A thread06A = new Thread06A(pc06);
            thread06A.start();
            Thread06B thread06B = new Thread06B(pc06);
            thread06B.start();
        }
    }
}
