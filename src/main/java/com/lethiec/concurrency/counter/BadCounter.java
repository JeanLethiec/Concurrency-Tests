package com.lethiec.concurrency.counter;

public class BadCounter implements Counter {
    private int count = 0;

    public int increment() {
        count++;
        return count;
    }

    public int decrement() {
        count--;
        return count;
    }
}
