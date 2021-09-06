package com.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程
 * 使用Callable和FutureTask创建线程，FutureTask.get()方法获取线程返回值
 * @Author wendongchao
 * @Date 2021/9/6 0:09
 */
public class CreateThread05 implements Callable<String> {

    // 1. 创建一个类实现 Callable 接口，并重写 call() 方法。
    @Override
    public String call() {
        return "hello";
    }

    public static void main(String[] args) {
        // 2. 创建该 Callable 接口实现类的实例。
        CreateThread05 thread05 = new CreateThread05();
        // 3. 将 Callable 的实现类实例传入 FutureTask(Callable<V> callable) 构造方法中创建 FutureTask 实例。
        FutureTask<String> futureTask = new FutureTask<>(thread05);
        // 4. 将 FutureTask 实例传入 Thread(Runnable r) 构造方法中创建 Thread 实例。
        Thread thread = new Thread(futureTask);
        // 5. 调用该 Thread 线程对象的 start() 方法。
        thread.start();
        // 6. 调用 FutureTask 实例对象的 get() 方法获取返回值。
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
