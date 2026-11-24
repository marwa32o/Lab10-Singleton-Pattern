package com.uet.billing.lab09_singletonpattern;

public class Task1Main {

    public static void main(String[] args) {
        System.out.println("=== LAB TASK 1: CENTRALIZED DATABASE CONNECTION MANAGER ===\n");

        // Three independent modules requesting DB connection
        DatabaseConnectionManager studentPortal = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager feeBillingService = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager attendanceTracker = DatabaseConnectionManager.getInstance();

        // Print identity hash codes
        System.out.println("\n--- Identity Hash Codes ---");
        System.out.println("StudentPortal HashCode     : " + System.identityHashCode(studentPortal));
        System.out.println("FeeBillingService HashCode : " + System.identityHashCode(feeBillingService));
        System.out.println("AttendanceTracker HashCode : " + System.identityHashCode(attendanceTracker));

        // Execute sample queries
        System.out.println("\n--- Executing Queries ---");
        studentPortal.executeQuery("StudentPortal", "SELECT * FROM students WHERE semester = 5;");
        feeBillingService.executeQuery("FeeBillingService", "UPDATE invoices SET status = 'PAID' WHERE id = 1042;");
        attendanceTracker.executeQuery("AttendanceTracker", "INSERT INTO attendance (student_id, status) VALUES (201, 'PRESENT');");

        // Prove single instantiation using ==
        System.out.println("\n--- Verification ---");
        boolean allSame = (studentPortal == feeBillingService) && (feeBillingService == attendanceTracker);
        System.out.println("All three references point to the same object (==): " + allSame);
        System.out.println("Total times constructor executed: " + DatabaseConnectionManager.getConstructorCallCount());
    }
}