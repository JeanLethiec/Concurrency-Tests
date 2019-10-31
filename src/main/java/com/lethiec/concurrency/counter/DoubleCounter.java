package com.lethiec.concurrency.counter;

public class DoubleCounter {
    private int c1 = 0;
    private int c2 = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();


    public void inc1() {
        synchronized (lock1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized (lock2) {
            c2++;
        }
    }
}
