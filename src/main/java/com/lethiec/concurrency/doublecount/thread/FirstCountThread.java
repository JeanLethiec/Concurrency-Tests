package com.lethiec.concurrency.doublecount.thread;

import com.lethiec.concurrency.doublecount.counter.DoubleCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstCountThread implements Runnable {
    private Logger logger = LoggerFactory.getLogger(FirstCountThread.class);

    private final DoubleCounter counter;

    public FirstCountThread(DoubleCounter counter) {
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
            counter.inc1();
        }
    }
}
