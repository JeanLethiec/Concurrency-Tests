package com.lethiec.concurrency;

public class CountThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(this + ": " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
