package com.jackshenorion.thinkinjava.sample.io;

import java.io.*;

/**
 * Created by jack on 27/05/2017.
 */
public class ReadFileSample {

    public static final String filePath = "/Users/jack/temp/generateCharactersByArray.txt";

    public static void readFile(String file) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        readFile(filePath);
    }
}
