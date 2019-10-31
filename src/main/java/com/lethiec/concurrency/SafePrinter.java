package com.lethiec.concurrency;

public class SafePrinter {
    public static synchronized void safePrint(String value) {
        System.out.println(value);
    }
}
