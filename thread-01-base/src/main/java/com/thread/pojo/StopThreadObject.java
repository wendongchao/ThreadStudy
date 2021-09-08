package com.thread.pojo;

import lombok.Data;

/**
 * @Author wendongchao
 * @Date 2021/9/9 0:07
 */
@Data
public class StopThreadObject {
    private String name = "a";
    private String password = "aa";

    public void printString(String name, String password) {
        try {
            this.name = name;
            Thread.sleep(1000);
            this.password = password;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
