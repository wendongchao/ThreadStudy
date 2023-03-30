package com.thread.waitnotify.pojo;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @auther: dongchao
 * @data: 2023/3/30 18:25
 */
public class PipedWrite {
    public void pipedWriteMethod(PipedWriter out) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 15; i++) {
                String msg = "" + (i + 1);
                System.out.print(msg);
                out.write(msg);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
