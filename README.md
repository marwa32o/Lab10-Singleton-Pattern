# Lab Task 10 - Creational Design Patterns: The Singleton Pattern

**Course:** Software Construction (5th Semester Software Engineering)
**Institution:** University of Engineering and Technology, Abbottabad Campus
**Lab Engineer:** Engr. Rizwan Shah

## Task Descriptions
1. **Task 1 - Centralized Database Connection Manager (`DatabaseConnectionManager`):** Implements a Lazy Singleton with a private constructor and instantiation counter so `StudentPortal`, `FeeBillingService`, and `AttendanceTracker` share a single database connection reference.
2. **Task 2 - Campus Print Spooler Queue (`PrintSpooler`):** Encapsulates a shared FIFO `Queue<String>` across `SoftwareLab1` and `NetworkingLab2` to maintain consistent shared state.
3. **Task 3 - Thread-Safe Audit Logger (`AuditLogger`):** Demonstrates a multithreaded race condition in a naive lazy Singleton across 5 threads and resolves it using `volatile` and Double-Checked Locking (`synchronized`).

## How to Run the Code (NetBeans)
1. Open the project in Apache NetBeans under package `com.uet.billing.lab09_singletonpattern`.
2. Right-click `Task1Main.java`, `Task2Main.java`, or `Task3Main.java` and select **Run File** (`Shift + F6`).
