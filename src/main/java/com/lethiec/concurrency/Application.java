package com.lethiec.concurrency;

import com.lethiec.concurrency.counter.BadCounter;
import com.lethiec.concurrency.counter.Counter;
import com.lethiec.concurrency.counter.GoodCounter;
import com.lethiec.concurrency.thread.ContinuousCountThread;
import com.lethiec.concurrency.thread.EachSecondCountThread;
import com.lethiec.concurrency.thread.SingleCounterThread;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting main thread.");

        //scenarioLaunchThreads();

        //scenarioInterruptThreadsWithAutomaticInterruptHandling();

        //scenarioInterruptThreadsWithManualInterruptHandling();

        //scenarioThreadWaitsForAnotherThreadToFinish();

        //scenarioMultipleThreadsAccessTheSameBadCounter();

        scenarioMultipleThreadsAccessTheSameGoodCounter();

        System.out.println("Terminating main thread.");
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

    static void scenarioThreadWaitsForAnotherThreadToFinish() throws InterruptedException {
        var thread = new Thread(new EachSecondCountThread());
        thread.start();

        // Here the main thread (main) waits for this new thread to end before executing further code.
        thread.join();
    }

    static void scenarioMultipleThreadsAccessTheSameBadCounter() throws InterruptedException {
        // This is a bad example as the Counter does not take synchronization into account.
        Counter counter = new BadCounter();
        new Thread(new SingleCounterThread(counter, "first")).start();
        new Thread(new SingleCounterThread(counter, "second")).start();
        new Thread(new SingleCounterThread(counter, "third")).start();
    }

    static void scenarioMultipleThreadsAccessTheSameGoodCounter() throws InterruptedException {
        // This is weird
        Counter counter = new GoodCounter();
        var thread1 = new Thread(new SingleCounterThread(counter, "first"));
        thread1.start();
        var thread2 = new Thread(new SingleCounterThread(counter, "second"));
        thread2.start();
        var thread3 = new Thread(new SingleCounterThread(counter, "third"));
        thread3.start();
    }
}
