import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: $" + amount + " | Current Balance: $" + balance);
        notifyAll();
    }

    public synchronized void withdraw(double amount) {
        while (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " waiting to withdraw $" + amount + " | Insufficient Balance: $" + balance);
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + " | Current Balance: $" + balance);
    }

    public synchronized double getBalance() {
        return balance;
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Enter withdrawal amount for Thread-1: ");
        double w1 = scanner.nextDouble();

        System.out.print("Enter deposit amount for Thread-2: ");
        double d1 = scanner.nextDouble();

        System.out.print("Enter withdrawal amount for Thread-3: ");
        double w2 = scanner.nextDouble();

        BankAccount account = new BankAccount(initialBalance);

        Thread t1 = new Thread(() -> account.withdraw(w1), "WithdrawalThread-1");
        Thread t2 = new Thread(() -> account.deposit(d1), "DepositThread-1");
        Thread t3 = new Thread(() -> account.withdraw(w2), "WithdrawalThread-2");

        t1.start();
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Account Balance: $" + account.getBalance());
        scanner.close();
    }
}