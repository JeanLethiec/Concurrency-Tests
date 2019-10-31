package com.lethiec.concurrency.thread;

import com.lethiec.concurrency.SafePrinter;
import com.lethiec.concurrency.counter.Counter;

public class SingleCounterThread implements Runnable {
    private Counter counter;
    private String title;

    public SingleCounterThread(Counter counter, String title) {
        this.counter = counter;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I've been interrupted !");
                return;
            }

            System.out.println(getTitle() + ": " + counter.increment());
        }
    }
}
