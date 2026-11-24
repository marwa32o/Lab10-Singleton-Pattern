package com.uet.billing.lab09_singletonpattern;

public class Task3Main {

    public static void main(String[] args) {
        System.out.println("=== LAB TASK 3: MULTITHREADED AUDIT LOGGER ===\n");

        Runnable loggerTask = () -> {
            AuditLogger logger = AuditLogger.getInstance();
            System.out.println(Thread.currentThread().getName()
                    + " -> AuditLogger Identity HashCode: " + System.identityHashCode(logger));
        };

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(loggerTask, "Audit-Thread-" + (i + 1));
        }

        // Start all 5 threads concurrently
        for (Thread t : threads) {
            t.start();
        }
    }
}