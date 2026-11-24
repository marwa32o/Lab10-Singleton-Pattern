package com.uet.billing.lab09_singletonpattern;

public class NetworkingLab2 {

    private final PrintSpooler spooler;

    public NetworkingLab2() {
        this.spooler = PrintSpooler.getInstance();
    }

    public void submitPrintJob(String documentName) {
        spooler.addPrintJob("NetworkingLab2", documentName);
    }

    public int getSpoolerIdentityHashCode() {
        return System.identityHashCode(spooler);
    }
}