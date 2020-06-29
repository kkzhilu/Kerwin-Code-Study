package com.code.jvm.preheat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/30 1:32
 * description:  TODO
 * version:      V1.0
 * ******************************
 */
public class DemoConsumer {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int)(Math.random() * 100));
        }

        Consumer consumer = o -> {
            int curr = (int) o;
        };

        System.out.println("foreach time: " + getTime(list, consumer));
    }

    private static long getTime(List<Integer> list, Consumer<Integer> consumer) {
        long start = System.currentTimeMillis();
        list.forEach(consumer);
        return System.currentTimeMillis() - start;
    }
}
