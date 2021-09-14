package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 18:09
 */
public class SynchronizedThreadPO081 {
    public int i = 10;
    synchronized public void methodA(){
        try {
            i--;
            System.out.println("methodA i="+i);
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
