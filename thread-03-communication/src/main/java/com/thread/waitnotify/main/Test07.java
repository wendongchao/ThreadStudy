package com.thread.waitnotify.main;

import com.thread.waitnotify.pojo.PipedInput;
import com.thread.waitnotify.pojo.PipedOutput;
import com.thread.waitnotify.pojo.ThreadInput;
import com.thread.waitnotify.pojo.ThreadOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道：pipeStream,用于在不同线程间直接传送数据
 * 分为字节流，字符流
 * 字节流：pipedInputStream,pipedOutputStream
 * 字符流：pipedWriter,pipedReader
 * @auther: dongchao
 * @data: 2023/3/30 15:58
 */
public class Test07 {
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedOutput pipedOutput = new PipedOutput();
        PipedInput pipedInput = new PipedInput();

        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

//        pipedInputStream.connect(pipedOutputStream);
        pipedOutputStream.connect(pipedInputStream);

        ThreadInput threadInput = new ThreadInput(pipedInput,pipedInputStream);
        threadInput.start();

        Thread.sleep(2000);

        ThreadOutput threadOutput = new ThreadOutput(pipedOutput,pipedOutputStream);
        threadOutput.start();
    }
}
