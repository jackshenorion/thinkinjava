package com.jackshenorion.thinkinjava.sample.network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by jack on 28/05/2017.
 */
public class UrlSample {


    public static void testUrl() {
        List<String> protocols = Arrays.asList("http", "https", "ftp", "mailto", "file",
            "telnet", "gopher", "ldap", "jar", "nfs",
            "jdbc", "rmi", "doc", "netdoc");
        String path = "://foo.com";
        for (String p : protocols) {
            try {
                URL url = new URL(p + path);
                System.out.println(p + " is supported");
            } catch (MalformedURLException e) {
                System.out.println(p + " is not supported: " + e.getMessage());
            }
        }
    }

    public static void testCreatingRelativeUrl() {
        try {
            URL url1 = new URL("http://www.google.com/index.html");
            System.out.println(url1);
            URL url2 = new URL(url1, "/default.html");
            System.out.println(url2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static String filePath = "/Users/jack/temp/test_to_url";

    public static void testToUrl() {
        System.out.println(new File(filePath).toURI()); // expect: file:/Users/jack/temp/test_to_url
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(ClassLoader.getSystemResource("./application.properties"));
        try {
            Enumeration<URL> urls = ClassLoader.getSystemResources("");
            while (urls.hasMoreElements()) {
                System.out.println(urls.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testClassPath() {

        Class clazz = new UrlSample().getClass();
        System.out.println(clazz.getResource(""));
    }

    public static void testUrlInputStream() {
        try(InputStream input = ClassLoader.getSystemResource("./application.properties").openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = null;
            while ((s = reader.readLine()) != null ) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testUrlInputStream2() {
        try(InputStream input = new URL("http://www.google.com.au").openStream()) {
            System.out.println(input.getClass().getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = null;
            while ((s = reader.readLine()) != null ) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testUrlGetContent() {
        try {
            Object input = new URL("http://www.google.com.au").getContent();
            System.out.println(input.getClass().getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) input));
            String s = null;
            while ((s = reader.readLine()) != null ) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getUrlStreamClass(String path) {
        try (InputStream input = new URL(path).openStream()) {
            System.out.println("openStream " + "path" + ":"  + input.getClass().getName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getUrlContentClass(String path) {
        try {
            Object input = new URL(path).getContent();
            System.out.println("openStream " + "path" + ":"  + input.getClass().getName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compareStreamContent() {
        String path1 = "http://cdn.oreillystatic.com/images/sitewide-headers/ml-header-home-blinking.gif";
        String path2 = "http://www.oreilly.com/";
        getUrlStreamClass(path1);
        getUrlContentClass(path1);
        getUrlStreamClass(path2);
        getUrlContentClass(path2);
    }

    public static void testUrlComponents() {
        try {
            URL url = new URL("http://jackshen:password@cdn.oreillystatic.com/images/sitewide-headers/ml-header-home-blinking.gif?color=green#middle");
            System.out.println("protocol:" + url.getProtocol());
            System.out.println("authority:" + url.getAuthority());
            System.out.println("path:" + url.getPath());
            System.out.println("file:" + url.getFile());
            System.out.println("userinfo:" + url.getUserInfo());
            System.out.println("host" + url.getHost());
            System.out.println("port" + url.getPort());
            System.out.println("defaultport:" + url.getDefaultPort());
            System.out.println("query:" + url.getQuery());
            System.out.println("ref:" + url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        testUrl();
//        testCreatingRelativeUrl();
//        testToUrl();
//        testClassPath();
//        testUrlInputStream();
//        testUrlInputStream2();
//        testUrlGetContent();
//        compareStreamContent();
        testUrlComponents();
    }
}
