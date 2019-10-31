package com.lethiec.concurrency.singlecount.thread;

public class EachSecondCountThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I've been interrupted !");
                return;
            }
            System.out.println(this + ": " + i);

        }
    }
}
