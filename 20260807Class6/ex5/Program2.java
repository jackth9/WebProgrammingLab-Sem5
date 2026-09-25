import java.util.Scanner;

class PriorityTask implements Runnable {
    private String name;
    private long workDuration;

    public PriorityTask(String name, long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }

    @Override
    public void run() {
        System.out.println(name + " started execution.");
        try {
            Thread.sleep(workDuration);
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " completed execution.");
    }
}

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sleep time for highest priority threads (in ms): ");
        long highPrioritySleep = scanner.nextLong();

        System.out.print("Enter work time for other threads (in ms): ");
        long normalSleep = scanner.nextLong();

        Thread t1 = new Thread(new PriorityTask("Thread-1", normalSleep), "Thread-1");
        Thread t2 = new Thread(new PriorityTask("Thread-2", normalSleep), "Thread-2");
        Thread t3 = new Thread(new PriorityTask("Thread-3", normalSleep), "Thread-3");
        Thread t4 = new Thread(new PriorityTask("Thread-4", highPrioritySleep), "Thread-4");
        Thread t5 = new Thread(new PriorityTask("Thread-5", highPrioritySleep), "Thread-5");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(3);
        t3.setPriority(Thread.NORM_PRIORITY);
        t4.setPriority(8);
        t5.setPriority(Thread.MAX_PRIORITY);

        Thread[] threads = {t1, t2, t3, t4, t5};

        System.out.println("\nStarting all threads...");
        for (Thread t : threads) {
            t.start();
        }

        System.out.println("Thread-4 is sending to sleep with priority: " + t4.getPriority());
        System.out.println("Thread-5 is sending to sleep with priority: " + t5.getPriority());

        System.out.println("\nChecking aliveness status right after start:");
        for (Thread t : threads) {
            System.out.println(t.getName() + " isAlive: " + t.isAlive());
        }

        Thread longLasting = null;
        for (Thread t : threads) {
            try {
                t.join();
                longLasting = t;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nChecking aliveness after completion:");
        for (Thread t : threads) {
            System.out.println(t.getName() + " isAlive: " + t.isAlive());
        }

        if (longLasting != null) {
            System.out.println("\nThe longest lasting thread was: " + longLasting.getName());
        }

        scanner.close();
    }
}