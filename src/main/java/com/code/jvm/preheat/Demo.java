package com.code.jvm.preheat;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/29 0:18
 * description:  Lambda foreach
 * version:      V1.0
 * ******************************
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int)(Math.random() * 100));
        }

        Thread.sleep(5 * 1000);

        System.out.println("foreach time one: " + getTime(list));

        System.out.println("分割线...");

        System.out.println("foreach time two: " + getTime(list));
    }

    private static long getTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        list.forEach(integer -> {
            int curr = integer;
        });

        return System.currentTimeMillis() - start;
    }

    private static long getTimeFor(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (Integer integer : list) {
            int curr = integer;
        }

        return System.currentTimeMillis() - start;
    }
}
