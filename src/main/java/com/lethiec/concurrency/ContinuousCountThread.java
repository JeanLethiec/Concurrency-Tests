package com.lethiec.concurrency;

public class ContinuousCountThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i<10000; i++) {
            System.out.println(this + ": " + i);
            // I have to check manually because no function does it for me.
            if (Thread.interrupted()) {
                System.out.println("I've been interrupted !");
                return;
            }
        }
    }
}
