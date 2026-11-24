package com.uet.billing.lab09_singletonpattern;

public class AuditLogger {

    // volatile prevents instruction reordering and guarantees visibility across threads
    private static volatile AuditLogger instance;

    private AuditLogger() {
        // Private constructor
    }

    // Thread-safe Double-Checked Locking
    public static AuditLogger getInstance() {
        if (instance == null) {
            synchronized (AuditLogger.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    instance = new AuditLogger();
                }
            }
        }
        return instance;
    }
}