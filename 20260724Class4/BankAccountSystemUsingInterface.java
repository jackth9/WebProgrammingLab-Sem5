import java.util.*;

interface Account{

    void deposit(double amount);
    void withdraw(double amount);
    void calculateInterest();
    void viewBalance();
}

class SavingsAccount implements Account{

    double balance=10000;

    public void deposit(double amt){
        balance+=amt;
    }

    public void withdraw(double amt){
        balance-=amt;
    }

    public void calculateInterest(){
        System.out.println("Interest : "+balance*0.05);
    }

    public void viewBalance(){
        System.out.println(balance);
    }

    void minimumBalance(){
        System.out.println("Minimum Balance =1000");
    }
}

class CurrentAccount implements Account{

    double balance=20000;

    public void deposit(double amt){
        balance+=amt;
    }

    public void withdraw(double amt){
        balance-=amt;
    }

    public void calculateInterest(){
        System.out.println("Interest : "+balance*0.02);
    }

    public void viewBalance(){
        System.out.println(balance);
    }

    void overdraft(){
        System.out.println("Overdraft Available");
    }
}

class Bank{

    ArrayList<Account> accounts=new ArrayList<>();

    void addAccount(Account a){
        accounts.add(a);
    }
}

public class BankAccountSystemUsingInterface {

    public static void main(String args[]){

        Bank b=new Bank();

        SavingsAccount s=new SavingsAccount();
        CurrentAccount c=new CurrentAccount();

        b.addAccount(s);
        b.addAccount(c);

        s.deposit(1000);
        System.out.print("Savings Account Balance: ");
	s.viewBalance();

        c.withdraw(500);
        System.out.print("Current Account Balance: ");
	c.viewBalance();
    }
}
