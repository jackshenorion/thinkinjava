package com.jackshenorion.thinkinjava.sample.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamSample {

    private static String outputPath = "/Users/jack/temp/";

    public static void writeUsingOutputStream() {

        OutputStream fileOutput = null;

        try {
            String outputFileName = "output_stream_sample_1.txt";
            fileOutput = new FileOutputStream(outputPath + outputFileName);
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

    public static OutputStream openOutputStream(String filePath) throws IOException {
        return new FileOutputStream(filePath);
    }

    public static void closeOutputStream(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 这个是每次写入一个字节
     */
    public static void generateCharacters(OutputStream out) throws IOException {
        final int MAX_CHAR_PER_LINE = 72;
        final int MIN_CHAR = 33;
        final int MAX_CHAR = 126;

        for (int i = 0; i < 100; i ++) {
            for (int j = 0; j < MAX_CHAR_PER_LINE; j ++) {
                out.write(((i + j) % (MAX_CHAR - MIN_CHAR + 1)) + MIN_CHAR); // 缠绕
            }
            out.write('\r');
            out.write('\n');
        }
    }

    /**
     * 这个是每次写入一个字节数组,效率比每次只写入一个字符要好一些
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
        }
    }

    public static void generateChracters() {
        OutputStream out = null;
        try {
            out = openOutputStream(outputPath + "generateCharactersByArray.txt");
            generateCharactersByArray(out);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeOutputStream(out);
        }
    }

    public static void main(String[] args) {
        generateChracters();

    }



}
