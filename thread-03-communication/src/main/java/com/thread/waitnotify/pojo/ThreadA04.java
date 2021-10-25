package com.thread.waitnotify.pojo;

/**
 * @author wendongchao
 * @ClassName ThreadA01
 * @Date 2021/10/11 17:12
 */
public class ThreadA04 extends Thread {
    private Producer04 p;
    public ThreadA04(Producer04 p) {
        this.p = p;
    }

    @Override
    public void run() {
      while (true) {
          p.setValue();
      }
    }
}
