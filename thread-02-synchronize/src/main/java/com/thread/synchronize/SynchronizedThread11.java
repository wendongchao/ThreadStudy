package com.thread.synchronize;

import com.thread.pojo.Sub10;
import com.thread.pojo.ThreadA10;
import com.thread.pojo.ThreadB10;

/**
 * synchronized同步语句块
 * synchronized方法的缺点：
 * 线程a获取对象锁，并执行一个长时间任务，那么线程b一直等待
 * 示例：
 *
 * @Author wendongchao
 * @Date 2021/9/11 17:55
 */
public class SynchronizedThread11 {

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
