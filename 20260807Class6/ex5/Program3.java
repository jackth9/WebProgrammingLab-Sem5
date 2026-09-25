import java.util.Random;
import java.util.Scanner;

class SharedData {
    private int number;
    private boolean isGenerated = false;

    public synchronized void generateNumber(int num) {
        while (isGenerated) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        this.number = num;
        this.isGenerated = true;
        notifyAll();
    }

    public synchronized int getEvenNumber() throws InterruptedException {
        while (!isGenerated || number % 2 != 0) {
            wait();
        }
        int result = number;
        isGenerated = false;
        notifyAll();
        return result;
    }

    public synchronized int getOddNumber() throws InterruptedException {
        while (!isGenerated || number % 2 == 0) {
            wait();
        }
        int result = number;
        isGenerated = false;
        notifyAll();
        return result;
    }

    public synchronized boolean isEven() {
        return number % 2 == 0;
    }

    public synchronized boolean isGenerated() {
        return isGenerated;
    }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total count of numbers to generate: ");
        int totalCount = scanner.nextInt();

        SharedData sharedData = new SharedData();

        Thread generator = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < totalCount; i++) {
                try {
                    Thread.sleep(1000);
                    int val = rand.nextInt(100);
                    System.out.println("\nGenerated Number: " + val);
                    sharedData.generateNumber(val);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        Thread squareThread = new Thread(() -> {
            for (int i = 0; i < totalCount; i++) {
                try {
                    synchronized (sharedData) {
                        while (!sharedData.isGenerated() || !sharedData.isEven()) {
                            sharedData.wait();
                        }
                        int num = sharedData.getEvenNumber();
                        System.out.println("Square of " + num + " = " + (num * num));
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        Thread cubeThread = new Thread(() -> {
            for (int i = 0; i < totalCount; i++) {
                try {
                    synchronized (sharedData) {
                        while (!sharedData.isGenerated() || sharedData.isEven()) {
                            sharedData.wait();
                        }
                        int num = sharedData.getOddNumber();
                        System.out.println("Cube of " + num + " = " + (num * num * num));
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        generator.start();
        squareThread.start();
        cubeThread.start();

        try {
            generator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        squareThread.interrupt();
        cubeThread.interrupt();
        
        scanner.close();
    }
}