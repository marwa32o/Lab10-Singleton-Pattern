package com.uet.billing.lab09_singletonpattern;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {

    private static PrintSpooler instance;
    private final Queue<String> printQueue;

    private PrintSpooler() {
        printQueue = new LinkedList<>();
        System.out.println("[PrintSpooler] Centralized Print Spooler Service Initialized.");
    }

    public static synchronized PrintSpooler getInstance() {
        if (instance == null) {
            instance = new PrintSpooler();
        }
        return instance;
    }

    public synchronized void addPrintJob(String labName, String documentName) {
        String jobEntry = "[" + labName + "] " + documentName;
        printQueue.add(jobEntry);
        System.out.println("Enqueued -> " + jobEntry + " | Pending Jobs: " + getPendingJobCount());
    }

    public synchronized void processNextJob() {
        if (printQueue.isEmpty()) {
            System.out.println("Queue is empty. No jobs to process.");
        } else {
            String job = printQueue.poll();
            System.out.println("Processing (FIFO) -> " + job + " | Remaining Jobs: " + getPendingJobCount());
        }
    }

    public synchronized int getPendingJobCount() {
        return printQueue.size();
    }
}