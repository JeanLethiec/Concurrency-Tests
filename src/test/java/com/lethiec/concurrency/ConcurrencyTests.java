package com.lethiec.concurrency;

import com.lethiec.concurrency.doublecount.thread.FirstCountThread;
import com.lethiec.concurrency.doublecount.thread.SecondCountThread;
import com.lethiec.concurrency.singlecount.counter.BadCounter;
import com.lethiec.concurrency.singlecount.counter.Counter;
import com.lethiec.concurrency.doublecount.counter.DoubleCounter;
import com.lethiec.concurrency.singlecount.counter.GoodCounter;
import com.lethiec.concurrency.singlecount.thread.ContinuousCountThread;
import com.lethiec.concurrency.singlecount.thread.EachSecondCountThread;
import com.lethiec.concurrency.singlecount.thread.SingleCounterThread;
import org.junit.jupiter.api.Test;


class ConcurrencyTests {
    @Test
    void launchThreads() throws InterruptedException {
        var thread1 = new Thread(new EachSecondCountThread());
        thread1.start();
        Thread.sleep(333);
        var thread2 = new Thread(new EachSecondCountThread());
        thread2.start();
        Thread.sleep(333);
        var thread3 = new Thread(new EachSecondCountThread());
        thread3.start();
    }

    @Test
    void interruptThreadsWithAutomaticInterruptHandling() {
        var thread = new Thread(new EachSecondCountThread());
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Test
    void interruptThreadsWithManualInterruptHandling() {
        var thread = new Thread(new ContinuousCountThread());
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Test
    void threadWaitsForAnotherThreadToFinish() throws InterruptedException {
        var thread = new Thread(new EachSecondCountThread());
        thread.start();

        // Here the main thread (main) waits for this new thread to end before executing further code.
        thread.join();
    }

    @Test
    void multipleThreadsAccessingTheSameBadCounterShouldCreateInconsistencies() throws InterruptedException {
        // This is a bad example as the Counter does not take synchronization into account.
        // As a result, it is possible to see two println print the same value.
        Counter counter = new BadCounter();
        var thread1 = new Thread(new SingleCounterThread(counter, "first"));
        thread1.start();
        var thread2 = new Thread(new SingleCounterThread(counter, "second"));
        thread2.start();
        var thread3 = new Thread(new SingleCounterThread(counter, "third"));
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

    @Test
    void multipleThreadsAccessingTheSameGoodCounteShouldBeFine() throws InterruptedException {
        // This is correct (even though the sout aren't ordered, printing from the Counter itself whows that there
        // are no interferences.
        Counter counter = new GoodCounter();
        var thread1 = new Thread(new SingleCounterThread(counter, "first"));
        thread1.start();
        var thread2 = new Thread(new SingleCounterThread(counter, "second"));
        thread2.start();
        var thread3 = new Thread(new SingleCounterThread(counter, "third"));
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

    @Test
    void anExampleWithSynchronizedStatements() throws InterruptedException {
        DoubleCounter counter = new DoubleCounter();
        var thread1 = new Thread(new FirstCountThread(counter));
        thread1.start();
        var thread2 = new Thread(new SecondCountThread(counter));
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
