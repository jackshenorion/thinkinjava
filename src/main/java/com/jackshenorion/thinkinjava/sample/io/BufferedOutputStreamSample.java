package com.jackshenorion.thinkinjava.sample.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by jack on 27/05/2017.
 */
public class BufferedOutputStreamSample {

    public static void testBufferedOutputStream() {
        String path = "/Users/jack/temp/testBufferedOutputStream.txt";

        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(path), 500);
            generateCharactersByArrayOnlyOneLine(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在这个测试中,可以发现,只有当缓冲区满了,才会写入文件
     */
    public static void generateCharactersByArray(OutputStream out) throws IOException {
        final int MAX_CHAR_PER_LINE = 72;
        final int MIN_CHAR = 33;
        final int MAX_CHAR = 126;
        byte[] line = new byte[MAX_CHAR_PER_LINE + 2];

        for (int i = 0; i < 100; i ++) {
            for (int j = 0; j < MAX_CHAR_PER_LINE; j ++) {
                line[j] = (byte) (((i + j) % (MAX_CHAR - MIN_CHAR + 1)) + MIN_CHAR);
            }
            line[MAX_CHAR_PER_LINE] = '\r';
            line[MAX_CHAR_PER_LINE + 1] = '\n';
            out.write(line);
            System.out.println(i + " lines printed");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateCharactersByArrayOnlyOneLine(OutputStream out) throws IOException {
        final int MAX_CHAR_PER_LINE = 72;
        final int MIN_CHAR = 33;
        final int MAX_CHAR = 126;
        byte[] line = new byte[MAX_CHAR_PER_LINE + 2];

        for (int i = 0; i < 1; i ++) {
            for (int j = 0; j < MAX_CHAR_PER_LINE; j ++) {
                line[j] = (byte) (((i + j) % (MAX_CHAR - MIN_CHAR + 1)) + MIN_CHAR);
            }
            line[MAX_CHAR_PER_LINE] = '\r';
            line[MAX_CHAR_PER_LINE + 1] = '\n';
            out.write(line);
            out.flush(); // 如果没有这一句,就算流关闭了,缓冲流没满也不会写入文件
            System.out.println(i + " lines printed");
        }
    }

    public static void main(String[] args) {
        testBufferedOutputStream();
    }
}
