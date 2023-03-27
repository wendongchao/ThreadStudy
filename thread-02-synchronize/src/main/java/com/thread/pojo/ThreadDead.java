package com.thread.pojo;

/**
 * @auther: dongchao
 * @data: 2023/3/27 16:52
 */
public class ThreadDead implements Runnable {
    private String username;

    private Object lock1 = new Object();
    private Object lock2 = new Object();


    @Override
    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username="+username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("lock1--->lock2");
                }
            }
        }

        if (username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username="+username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("lock2--->lock1");
                }
            }
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
