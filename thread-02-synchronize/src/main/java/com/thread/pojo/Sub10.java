package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName Sub10
 * @Date 2021/9/15 18:14
 */
public class Sub10 extends Main10 {

    @Override
    public void method() {
        try {
            System.out.println("int sub sleep begin threadName="
                    + Thread.currentThread().getName()
                    + ", time=" + System.currentTimeMillis());
            Thread.sleep(500);
            System.out.println("int sub sleep end threadName="
                    + Thread.currentThread().getName()
                    + ", time=" + System.currentTimeMillis());
            super.method();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
