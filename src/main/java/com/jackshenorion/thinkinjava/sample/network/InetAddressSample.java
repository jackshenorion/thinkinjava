package com.jackshenorion.thinkinjava.sample.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by jack on 27/05/2017.
 */
public class InetAddressSample {

    public static void testInetAddress() {
        try {

            System.out.println("=============================");
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address);
            System.out.println("getHostAddress:" + address.getHostAddress());
            System.out.println("getHostName:" + address.getHostName());
            System.out.println("getCanonicalHostName:" + address.getCanonicalHostName());

            System.out.println("=============================");
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            for (InetAddress addr : addresses) {
                System.out.println(addr);
            }

            System.out.println("=============================");
            InetAddress address3 = InetAddress.getLocalHost();
            System.out.println(address3);

            System.out.println("=============================");
            InetAddress address4 = InetAddress.getLoopbackAddress();
            System.out.println(address4);

            System.out.println("=============================");
            InetAddress[] addresses5 = InetAddress.getAllByName("Jacks-MacBook-Pro.local");
            for (InetAddress addr : addresses5) {
                System.out.println(addr);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static void searchLocalNet() {
        byte[] addr = {(byte) 192, (byte) 168, 0, 1};
        for (int i = 1; i < 255; i ++) {
            addr[3] = (byte) i;
            try {
                InetAddress inetAddress = InetAddress.getByAddress(addr);
                try {
                    boolean isReachable = inetAddress.isReachable(5000);
                    System.out.println(inetAddress + (isReachable ? " is reachable" : " is not reachable"));
                } catch (IOException e) {
                    System.out.println(inetAddress + " is not reachable (exception)");
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testGetHostName() {
        try {
            InetAddress address1 = InetAddress.getByName("www.unohomeloans.com.au");
            System.out.println(address1); // 通过主机名创建,会访问dns服务器
            InetAddress address2 = InetAddress.getByName(address1.getHostAddress());
            System.out.println(address2); //通过ip地址创建,不会访问dns,所以没有主机名
            address2.getHostName();
            System.out.println(address2); //调用了getHostName,需要访问dns,所以主机名出现
            System.out.println(address2.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void testGetAddress() {
        try {
            InetAddress address = InetAddress.getByName("www.unohomeloans.com.au");
            byte[] addr = address.getAddress();
            for (byte seg : addr) {
                System.out.print(seg + " ");
            }
            System.out.println();
            for (byte seg : addr) {
                System.out.print((int) seg + " ");
            }

            System.out.println();
            for (byte seg : addr) {
                System.out.print(((int) seg < 0 ? seg + 256: seg ) + " ");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void getIpCharacteritics(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            System.out.println("========");
            System.out.println(address.isAnyLocalAddress());
            System.out.println(address.isLinkLocalAddress());
            System.out.println(address.isLoopbackAddress());
            System.out.println(address.isSiteLocalAddress());
            System.out.println(address.isMCGlobal());
            System.out.println(address.isMCLinkLocal());
            System.out.println(address.isMCOrgLocal());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        getIpCharacteritics("127.0.0.1");
//        getIpCharacteritics("192.168.0.1");
//        getIpCharacteritics("224.0.0.1");
//        getIpCharacteritics("www.unohomeloans.com.au");
        searchLocalNet();
    }
}
