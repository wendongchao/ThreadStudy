package com.thread.waitnotify.pojo;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @auther: dongchao
 * @data: 2023/3/30 18:07
 */
public class ThreadInput extends Thread{
    private PipedInput input;
    private PipedInputStream inputStream;

    public ThreadInput(PipedInput input, PipedInputStream inputStream) {
        this.input = input;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
      input.pipedInputMethod(inputStream);
    }
}
