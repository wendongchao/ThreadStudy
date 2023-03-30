package com.thread.waitnotify.pojo;

import java.io.PipedWriter;

/**
 * @auther: dongchao
 * @data: 2023/3/30 18:28
 */
public class ThreadWrite extends Thread{
    private PipedWrite out;
    private PipedWriter writer;

    public ThreadWrite(PipedWrite out, PipedWriter writer) {
        this.out = out;
        this.writer = writer;
    }

    @Override
    public void run() {
        out.pipedWriteMethod(writer);
    }
}
