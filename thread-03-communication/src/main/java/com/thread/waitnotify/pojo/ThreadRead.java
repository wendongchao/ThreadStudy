package com.thread.waitnotify.pojo;

import java.io.PipedReader;

/**
 * @auther: dongchao
 * @data: 2023/3/30 18:30
 */
public class ThreadRead extends Thread{
    private PipedRead read;
    private PipedReader reader;

    public ThreadRead(PipedRead read,PipedReader reader) {
        this.read = read;
        this.reader = reader;
    }

    @Override
    public void run() {
        read.pipedReadMethod(reader);
    }
}
