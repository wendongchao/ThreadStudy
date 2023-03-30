package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.PipedRead;
import com.thread.waitnotify.pojo.PipedWrite;
import com.thread.waitnotify.pojo.ThreadRead;
import com.thread.waitnotify.pojo.ThreadWrite;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @auther: dongchao
 * @data: 2023/3/30 18:24
 */
public class Test08 {
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedRead pipedRead = new PipedRead();
        PipedWrite pipedWrite = new PipedWrite();

        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();

        reader.connect(writer);

        ThreadRead threadRead = new ThreadRead(pipedRead,reader);
        threadRead.start();

        Thread.sleep(2000);

        ThreadWrite threadWrite = new ThreadWrite(pipedWrite,writer);
        threadWrite.start();
    }
}
