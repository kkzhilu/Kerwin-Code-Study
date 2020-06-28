package com.code.jvm.preheat;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/29 0:18
 * description:  JVM 预热 | 触发Demo
 * version:      V1.0
 * ******************************
 */
public class Demo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int)(Math.random() * 100));
        }

        System.out.println("foreach time one: " + getTime(list));

        System.out.println("foreach time two: " + getTime(list));
    }

    private static long getTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        list.forEach(integer -> {
            int curr = integer;
        });

        return System.currentTimeMillis() - start;
    }

    private static void threadTest(List<Integer> list) {
        new Thread(() -> {
            long start = System.currentTimeMillis();

            list.forEach(integer -> {
                int curr = integer;
            });

            System.out.println(System.currentTimeMillis() - start);
        }).run();
    }
}
