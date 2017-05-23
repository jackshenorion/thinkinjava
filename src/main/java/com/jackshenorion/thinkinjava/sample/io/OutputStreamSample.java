package com.jackshenorion.thinkinjava.sample.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamSample {

    private static String outputPath = "/Users/jack/temp";

    public static void writeUsingOutputStream() {

        /**
         * 1 OutputStream is only a interface, we can only create any use particular implementation,
         *   e.g. FileOutputStream, ByteArrayOutputStream, FilterOutputStream
         */

        OutputStream fileOutput = null;

        try {
            String outputFileName = "output_stream_sample_1.txt";
            fileOutput = new FileOutputStream(outputPath + "/" + outputFileName);
            for (int i = 0; i < 1000; i ++) {
                fileOutput.write((i + "\n").getBytes());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutput != null) {
                try {
                    fileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }



}
