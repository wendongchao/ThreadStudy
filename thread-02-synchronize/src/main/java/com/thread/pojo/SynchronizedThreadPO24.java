package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO24 {
   private Boolean flag = true;
   public void runMethod() {
       String str = new String();
       while (flag == true) {
           synchronized (str){

           }
       }
       System.out.println("停下来了");
   }
   public void stopMethod(){
       flag = false;
   }

}
