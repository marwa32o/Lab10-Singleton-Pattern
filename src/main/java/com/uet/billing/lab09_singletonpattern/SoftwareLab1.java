package com.uet.billing.lab09_singletonpattern;

public class SoftwareLab1 {

    private final PrintSpooler spooler;

    public SoftwareLab1() {
        this.spooler = PrintSpooler.getInstance();
    }

    public void submitPrintJob(String documentName) {
        spooler.addPrintJob("SoftwareLab1", documentName);
    }

    public int getSpoolerIdentityHashCode() {
        return System.identityHashCode(spooler);
    }
}