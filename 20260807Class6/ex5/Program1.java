import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total execution time in seconds: ");
        int totalSeconds = scanner.nextInt() -1;
        
        //make sure to comment this too
        //totalSeconds -= 1;
        
	CountDownLatch starter = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
	    try { starter.await(); } catch (InterruptedException e) {}
            long startTime = System.currentTimeMillis();
            long timeDelta;
            
            while (System.currentTimeMillis() - startTime < totalSeconds * 1000L) {
            
            //do {
                timeDelta = System.currentTimeMillis() - startTime;
                try {
                    Thread.sleep(1000);
                    
                    System.out.println("Hello!\t\t" + "timestamp " + timeDelta);
                } catch (InterruptedException e) {
                    break;
                }
            //} while (timeDelta < totalSeconds * 1000L);
            }
        });

        Thread t2 = new Thread(() -> {
	    try { starter.await(); } catch (InterruptedException e) {}
            long startTime = System.currentTimeMillis();
            long timeDelta;
            
            while (System.currentTimeMillis() - startTime < totalSeconds * 1000L) {
            
            //do {
                timeDelta = System.currentTimeMillis() - startTime;
                try {
                    Thread.sleep(2000);
                    System.out.println("Happy Holidays!\t" + "timestamp " + timeDelta);
                } catch (InterruptedException e) {
                    break;
                }
            //} while (timeDelta < totalSeconds * 1000L);
            }
        });

        Thread t3 = new Thread(() -> {
	        try { starter.await(); } catch (InterruptedException e) {}
            long startTime = System.currentTimeMillis();
            long timeDelta;

            while (System.currentTimeMillis() - startTime < totalSeconds * 1000L) {
            //do {
                timeDelta = System.currentTimeMillis() - startTime;
                try {
                    Thread.sleep(5000);
                    System.out.println("Enjoy!\t\t" + "timestamp " + timeDelta);
                } catch (InterruptedException e) {
                    break;
                }
            //} while (timeDelta < totalSeconds * 1000L);
            }
        });

        t1.start();
        t2.start();
        t3.start();

	starter.countDown();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        scanner.close();
    }
}