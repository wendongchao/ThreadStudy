package com.thread.pojo;

/**
 * @Author wendongchao
 * @Date 2021/9/11 17:17
 */
public class SuspendThreadPO02 {
    private String name = "1";
    private String password = "11";

    public void setValue(String name, String password) {
        this.name = name;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程停止");
            Thread.currentThread().suspend();
        }
        this.password = password;
    }

    public void printString() {
        System.out.println(name + " " + password);
    }

}
