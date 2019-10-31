package com.lethiec.concurrency.counter;

public class GoodCounter implements Counter {
    private int count = 0;

    public synchronized int increment() {
        count++;
        return count;
    }

    public synchronized int decrement() {
        count--;
        return count;
    }
}
