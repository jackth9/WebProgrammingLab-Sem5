import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to start printing alphabets...");
        scanner.nextLine();

        Thread firstThread = new Thread(() -> {
            System.out.println("First Thread Started (A to Z):");
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.print(ch + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("\nFirst Thread Completed Execution.\n");
        });

        Thread secondThread = new Thread(() -> {
            try {
                firstThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Second Thread Started (Z to A):");
            for (char ch = 'Z'; ch >= 'A'; ch--) {
                System.out.print(ch + " ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("\nSecond Thread Completed Execution.");
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Application finished: All threads execution complete.");
        scanner.close();
    }
}