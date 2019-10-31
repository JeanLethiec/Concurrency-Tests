package com.lethiec.concurrency;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        //scenarioLaunchThreads();

        //scenarioInterruptThreadsWithAutomaticInterruptHandling();

        scenarioInterruptThreadsWithManualInterruptHandling();
    }

    static void scenarioLaunchThreads() throws InterruptedException {
        new Thread(new EachSecondCountThread()).start();
        Thread.sleep(333);
        new Thread(new EachSecondCountThread()).start();
        Thread.sleep(333);
        new Thread(new EachSecondCountThread()).start();
    }

    static void scenarioInterruptThreadsWithAutomaticInterruptHandling() {
        var thread = new Thread(new EachSecondCountThread());
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    static void scenarioInterruptThreadsWithManualInterruptHandling() {
        var thread = new Thread(new ContinuousCountThread());
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
