package com.jackshenorion.thinkinjava.sample.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jack on 27/05/2017.
 */
public class InputStreamSample {

    public static byte[] getByteArray() {
        int size = 1000;
        StringBuilder sb = new StringBuilder();
        for (Integer i = 0; i < size; i++) {
            sb.append(i);
        }
        return sb.toString().getBytes();
    }

    public static void testInputStream() throws IOException {
        InputStream input = new ByteArrayInputStream(getByteArray());
        StringBuilder sb = new StringBuilder();
        for (int c = input.read(); c != -1; c = input.read()) {
            sb.append((char) c); // 注意,每次从InputStream中读出来的是二进制的字符
        }
        input.close();
        System.out.println(sb.toString());
    }

    public static void testInputStreamUsingArray() throws IOException {
        InputStream input = new ByteArrayInputStream(getByteArray());
        byte[] a = new byte[20];
        StringBuilder sb = new StringBuilder();
        for (int c = input.read(a); c != -1; c = input.read(a)) {
            System.out.println("read: " + c);
            sb.append(new String(a));
        }
        input.close();
        System.out.println(sb.toString());
    }

    public static void testInputStreamUsingArrayWithOffset() throws IOException {
        byte[] source = getByteArray();
        int length = source.length;

        InputStream input = new ByteArrayInputStream(getByteArray());
        byte[] a = new byte[length];

        int start = 0;
        int bytesPerRead = 20;
        System.out.println("total length: " + length);
        while (length > 0) {
            System.out.println("start: " + start);
            int n = input.read(a, start, Math.min(bytesPerRead, length));
            start += n;
            length -= n;
        }
        input.close();

        System.out.println(new String(a));
    }

    public static void testInputStreamWithCheckAvailable() throws IOException {
        InputStream input = new ByteArrayInputStream(getByteArray());

        byte[] a = new byte[20];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int available = input.available();
            if (available > 0) {
                int n = input.read(a);
                sb.append(new String(a, 0, n));
                System.out.println("read: " + n);
            } else if (available == 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("waiting...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
        input.close();

        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        try {
            testInputStreamWithCheckAvailable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
