package com.lethiec.concurrency.singlecount.counter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoodCounter implements Counter {
    private Logger logger = LoggerFactory.getLogger(GoodCounter.class);
    private int count = 0;

    public synchronized int increment() {
        count++;
        logger.info("GoodCounter: " + count);
        return count;
    }
}
