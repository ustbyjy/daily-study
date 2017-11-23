package com.ustbyjy.bean;

import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin {
    private final static AtomicInteger next = new AtomicInteger(0);

    private int select(int[] s) throws Exception {
        if (s == null || s.length == 0) {
            throw new Exception();
        } else {
            return s[next.getAndIncrement() % s.length];
        }
    }

    public static void main(String[] args) throws Exception {
        int[] s = {0, 1, 2, 3, 4};
        RoundRobin roundRobin = new RoundRobin();
        for (int i = 0; i < 12; i++) {
            System.out.println(roundRobin.select(s));
        }
    }
}
