package com.jackshenorion.thinkinjava.sample.io;

import com.sun.xml.internal.fastinfoset.Encoder;

import java.io.*;
import java.nio.charset.CharsetEncoder;

/**
 * Created by jack on 27/05/2017.
 */
public class ReaderWriterSample {

    public static final String filePath = "/Users/jack/temp/output_stream_writer_test";


    public static void testWriter() {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8")) {
            writer.write("abcd");
            writer.write('\r');
            writer.write('\n');
            writer.write("我是沈健");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testNoneWriter() {
        try (OutputStream out = new FileOutputStream(filePath)) {
            out.write("abcd".getBytes());
            out.write("我是沈健".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testNoneWriter();
    }
}
