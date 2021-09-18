package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO15 {
    private String name;
    private String password;
//    private String anyStr = new String();
    public void setValue(String name, String password) {
        try {
            String anyStr = new String();
            synchronized (anyStr) {
                System.out.println("线程名："+Thread.currentThread().getName()+", 进入代码块时间："+System.currentTimeMillis());
                name = name;
                Thread.sleep(100);
                password = password;
                System.out.println("线程名："+Thread.currentThread().getName()+", 离开代码块时间："+System.currentTimeMillis());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
