package com.uet.billing.lab09_singletonpattern;

public class DatabaseConnectionManager {

    private static DatabaseConnectionManager instance = null;
    private static int constructorCallCount = 0;

    private DatabaseConnectionManager() {
        constructorCallCount++;
        System.out.println("[DatabaseConnectionManager] Physical connection established with University DB.");
        System.out.println("[DatabaseConnectionManager] Constructor execution count: " + constructorCallCount);
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public void executeQuery(String moduleName, String sql) {
        System.out.println("[" + moduleName + "] Executing Query -> " + sql);
    }

    public static int getConstructorCallCount() {
        return constructorCallCount;
    }
}