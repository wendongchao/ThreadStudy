package com.thread.pojo;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO172 {
    public SynchronizedThreadPO171 addMethod(SynchronizedThreadPO171 list, String data) {
        try {
//            if (list.getSize() < 1) {
//                Thread.sleep(100);
//                list.add(data);// 非synchronized同步代码块中调用了同步方法，会造成脏读
//            }
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(100);
                    list.add(data);// 非synchronized同步代码块中调用了同步方法，会造成脏读
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return list;
    }
}
