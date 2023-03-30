package com.thread.waitnotify.pojo;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @auther: dongchao
 * @data: 2023/3/30 16:41
 */
public class PipedInput {
    public void pipedInputMethod(PipedInputStream input) {
        try {
            System.out.println("read:");
            byte[] byteArray = new byte[20];
            int length = input.read(byteArray);
            while (length != -1) {
                String data = new String(byteArray, 0, length);
                System.out.println(data);
                length = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
