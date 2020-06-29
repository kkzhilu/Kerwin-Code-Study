package com.code.jvm.preheat;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/29 15:09
 * description:  Lambda foreach
 * version:      V1.0
 * ******************************
 */
public class ThreadDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int)(Math.random() * 100));
        }

        threadTest(list);
    }

    private static void threadTest(List<Integer> list) {
        new Thread(() -> {
            System.out.println("分割线...");

            long start = System.currentTimeMillis();
            list.forEach(integer -> {
                int curr = integer;
            });
            System.out.println("耗时:" + (System.currentTimeMillis() - start));
        }).run();
    }
}
