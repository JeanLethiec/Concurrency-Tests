package com.lethiec.concurrency.doublecount.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoubleCounter {
    private Logger logger = LoggerFactory.getLogger(DoubleCounter.class);
    private int c1 = 0;
    private int c2 = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();


    public void inc1() {
        synchronized (lock1) {
            c1++;
            logger.info("C1: " + c1);
        }
    }

    public void inc2() {
        synchronized (lock2) {
            c2++;
            logger.info("C2: " + c2);
        }
    }
}
