package com.uet.billing.lab09_singletonpattern;

public class Task2Main {

    public static void main(String[] args) {
        System.out.println("=== LAB TASK 2: CAMPUS PRINT SPOOLER QUEUE ===\n");

        // Obtain PrintSpooler instances inside both simulated lab client classes
        SoftwareLab1 lab1 = new SoftwareLab1();
        NetworkingLab2 lab2 = new NetworkingLab2();

        System.out.println("\n--- Verifying Shared Spooler Instance ---");
        System.out.println("SoftwareLab1 Spooler HashCode   : " + lab1.getSpoolerIdentityHashCode());
        System.out.println("NetworkingLab2 Spooler HashCode : " + lab2.getSpoolerIdentityHashCode());
        System.out.println("Same Spooler Reference (==)     : " + (lab1.getSpoolerIdentityHashCode() == lab2.getSpoolerIdentityHashCode()));

        // Submit 2 print jobs from SoftwareLab1 and 1 print job from NetworkingLab2
        System.out.println("\n--- Submitting Print Jobs ---");
        lab1.submitPrintJob("SRS_Specification_v1.pdf");
        lab1.submitPrintJob("Singleton_Class_Diagram.png");
        lab2.submitPrintJob("Campus_Router_Config.pkt");

        // Process all jobs sequentially in FIFO order
        System.out.println("\n--- Processing All Queued Jobs Sequentially (FIFO) ---");
        PrintSpooler centralSpooler = PrintSpooler.getInstance();
        while (centralSpooler.getPendingJobCount() > 0) {
            centralSpooler.processNextJob();
        }
    }
}