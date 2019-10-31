package com.lethiec.concurrency;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting concurrency test application.");

        launchThreads();

        System.out.println("Ending concurrency test application.");
    }

    static void launchThreads() throws InterruptedException {
        new Thread(new CountThread()).start();
        Thread.sleep(333);
        new Thread(new CountThread()).start();
        Thread.sleep(333);
        new Thread(new CountThread()).start();
    }
}
