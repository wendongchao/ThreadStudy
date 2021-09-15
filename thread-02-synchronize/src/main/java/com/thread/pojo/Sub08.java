package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 18:09
 */
public class Sub08 extends Main08 {
        synchronized public void methodB() {
            try {
                while (i > 0) {
                    i--;
                    System.out.println("methodB i="+i);
                    Thread.sleep(100);
                    this.methodA();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
