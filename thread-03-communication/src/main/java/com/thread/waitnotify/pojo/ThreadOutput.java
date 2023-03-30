package com.thread.waitnotify.pojo;

import java.io.PipedOutputStream;

/**
 * @auther: dongchao
 * @data: 2023/3/30 18:07
 */
public class ThreadOutput extends Thread{
    private PipedOutput output;
    private PipedOutputStream outputStream;

    public ThreadOutput(PipedOutput output,PipedOutputStream outputStream) {
        this.output = output;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        output.pipedOutputMethod(outputStream);
    }
}
