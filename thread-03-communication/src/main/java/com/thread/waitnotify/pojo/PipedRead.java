package com.thread.waitnotify.pojo;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @auther: dongchao
 * @data: 2023/3/30 18:26
 */
public class PipedRead {
    public void pipedReadMethod(PipedReader input) {
        try {
            System.out.println("read:");
            char[] byteArray = new char[20];
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
