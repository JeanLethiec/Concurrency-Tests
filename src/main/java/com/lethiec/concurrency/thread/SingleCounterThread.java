package com.lethiec.concurrency.thread;

import com.lethiec.concurrency.counter.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleCounterThread implements Runnable {
    private Logger logger = LoggerFactory.getLogger(SingleCounterThread.class);
    private Counter counter;
    private String title;

    public SingleCounterThread(Counter counter, String title) {
        this.counter = counter;
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.warn("I've been interrupted !");
                return;
            }

            logger.info(getTitle() + ": " + counter.increment());
        }
    }
}
