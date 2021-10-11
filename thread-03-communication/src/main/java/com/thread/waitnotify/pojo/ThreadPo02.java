package com.thread.waitnotify.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wendongchao
 * @ClassName ThreadPo02
 * @Date 2021/10/11 18:27
 */
public class ThreadPo02 {
    private static List<String> list = new ArrayList<>();
    public static void add() {
        list.add("anyString");
    }
    public static int size() {
        return list.size();
    }
}
