package com.thread.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wendongchao
 * @ClassName SynchronizedThreadPO11
 * @Date 2021/9/15 19:09
 */
public class SynchronizedThreadPO171 {
    private List<String> list = new ArrayList<>();
    synchronized public void add(String data) {
        list.add(data);
    }
    synchronized public int getSize() {
        return list.size();
    }
}
