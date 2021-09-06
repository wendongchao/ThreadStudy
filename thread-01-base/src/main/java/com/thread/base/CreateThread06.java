package com.thread.base;

/**
 * 创建线程
 * 匿名内部类创建线程
 * @author wendongchao
 * @ClassName CreateThread06
 * @Date 2021/9/6 16:42
 */
public class CreateThread06 {
    public static void main(String[] args) {
        /*new Runnable(){
            public void run(){
                for(int i=0;i<20;i++){
                    System.out.println("李白："+i);
                }
            }
        };*/
        // 这是个整体，相当于new MyRunnable()
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<20;i++){
                    System.out.println("李白："+i);
                }
            }
        };
        new Thread(r).start();
    }
}
