package com.lu.thread.entity;

import java.util.concurrent.TimeUnit;

public class MutableInteger {
    private volatile int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        this.value = value;

    }


    public int test(int i) {
        return i;
    }

    public String test(String i) {
        return "1";
    }

}
