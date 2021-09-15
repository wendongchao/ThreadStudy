package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName Main10
 * @Date 2021/9/15 18:13
 */
public class Main10 {
    synchronized public void method(){
        try {
            System.out.println("int main sleep begin threadName="
                    + Thread.currentThread().getName()
                    + ", time=" + System.currentTimeMillis());
            Thread.sleep(500);
            System.out.println("int main sleep end threadName="
                    + Thread.currentThread().getName()
                    + ", time=" + System.currentTimeMillis());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
