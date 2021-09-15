package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 22:57
 */
public class ThreadB10 extends Thread{

    private Sub10 sub10;

    public ThreadB10(Sub10 sub10) {
        this.sub10 = sub10;
    }

    @Override
    public void run() {
        sub10.method();
    }


}
