package com.thread.waitnotify.pojo;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @auther: dongchao
 * @data: 2023/3/30 16:38
 */
public class PipedOutput {
    public void pipedOutputMethod(PipedOutputStream out) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 10; i++) {
                String msg = "" + (i + 1);
                System.out.print(msg);
                out.write(msg.getBytes());
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
