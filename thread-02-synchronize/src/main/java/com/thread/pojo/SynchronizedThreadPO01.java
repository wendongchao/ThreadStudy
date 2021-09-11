package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 18:09
 */
public class SynchronizedThreadPO01 {

    public void addI(String name) {
        try {
            int num = 0;
            if (name.equals("a")) {
                num = 100;
                System.out.println("time="+System.currentTimeMillis()+", a set over");
                Thread.sleep(100);
            }else {
                num = 200;
                System.out.println("time="+System.currentTimeMillis()+", b set over");
            }
            System.out.println("time="+System.currentTimeMillis()+ " " +name + " num=" + num);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
