package com.lethiec.concurrency.doublecount.thread;

import com.lethiec.concurrency.doublecount.counter.DoubleCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondCountThread implements Runnable {
    private Logger logger = LoggerFactory.getLogger(SecondCountThread.class);

    private final DoubleCounter counter;

    public SecondCountThread(DoubleCounter counter) {
        this.counter = counter;
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
            counter.inc2();
        }
    }
}
