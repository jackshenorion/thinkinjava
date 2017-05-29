package com.jackshenorion.thinkinjava.sample.io;

import java.io.*;

/**
 * Created by jack on 27/05/2017.
 */
public class DataInputOutputStreamSample {

    public static final String filePath = "/Users/jack/temp/data_output_stream_test";

    public static void testDataOutputStream() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath))) {
            for (double i = 0; i < 100; i ++) {
                out.writeDouble(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        testDataOutputStream();
    }
}
