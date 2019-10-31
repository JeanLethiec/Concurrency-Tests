package com.lethiec.concurrency.singlecount.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadCounter implements Counter {
    private Logger logger = LoggerFactory.getLogger(BadCounter.class);

    private int count = 0;

    public int increment() {
        count++;
        logger.info("BadCounter: " + count);
        return count;
    }
}
