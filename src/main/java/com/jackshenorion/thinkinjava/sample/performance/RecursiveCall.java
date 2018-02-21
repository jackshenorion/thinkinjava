package com.jackshenorion.thinkinjava.sample.performance;

import java.util.ArrayList;
import java.util.List;

public class RecursiveCall {

    static int count = 100;
    private Runtime rt = Runtime.getRuntime();
    private long prevUsed = 0;
    private long prevTime = System.currentTimeMillis();

    public RecursiveCall(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        new RecursiveCall(4000).runTest();
    }

    public void runTest() {
        printPerformance();
//        recursiveCall();
        normalCall();
        printPerformance();
    }

    private List<BigObject> recursiveCall() {
        List<BigObject> currentMsgs = new ArrayList<>();
        int n = 200;
        while (n-- > 0) {
            currentMsgs.add(new BigObject());
        }
        if (--count <= 0) {
            return currentMsgs;
        }
        currentMsgs.addAll(recursiveCall());
        return currentMsgs;
    }

    private List<BigObject> normalCall() {
        List<BigObject> allMsgs = new ArrayList<>();
        while (count -- > 1) {
            allMsgs.addAll(normalCallHelper());
        }
        return allMsgs;
    }

    private List<BigObject> normalCallHelper() {
        List<BigObject> currentMsgs = new ArrayList<>();
        int n = 200;
        while (n-- > 0) {
            currentMsgs.add(new BigObject());
        }
        return currentMsgs;
    }

    private void printPerformance() {
        long total = rt.totalMemory();
        long free = rt.freeMemory();
        long used = total - free;
        long currentTime = System.currentTimeMillis();
        System.out.println(
                String.format("#count %d, Total: %s, Free: %s, Used: %s, Runtime: %s",
                        count,
                        total,
                        free,
                        used - prevUsed,
                        currentTime - prevTime));
        prevUsed = used;
        prevTime = currentTime;
    }

    static class BigObject {
        Integer[] content = new Integer[1000];
    }
}
