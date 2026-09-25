class Account{

    protected double balance;
    String accountNumber;
    private double interestRate;

    Account(String acc,double balance,double rate){
        this.accountNumber=acc;
        this.balance=balance;
        this.interestRate=rate;
    }

    public void calculateInterest(){
        System.out.println("Interest = "+balance*interestRate/100);
    }

    public void validateDeposit(double amount){
        if(amount>0){
            updateBalance(amount);
        }
    }

    protected void updateBalance(double amount){
        balance+=amount;
    }
}

class SavingsAccount extends Account{

    double minimumBalance;

    SavingsAccount(String acc, double bal, double rate, double min){
        super(acc,bal,rate);
        minimumBalance=min;
    }

    void display(){
        System.out.println("Savings Balance : "+balance);
    }
}

class CurrentAccount extends Account{

    double overdraftLimit;

    CurrentAccount(String acc,double bal,double rate,double limit){
        super(acc,bal,rate);
        overdraftLimit=limit;
    }

    void display(){
        System.out.println("Current Balance : "+balance);
    }
}

public class BankAccountSystem {

    public static void main(String args[]){

        SavingsAccount s=new SavingsAccount("101",10000,5,1000);

        s.calculateInterest();
        s.validateDeposit(5000);
        s.display();

        CurrentAccount c=new CurrentAccount("102",5000,2,10000);

        c.calculateInterest();
        c.validateDeposit(3000);
        c.display();
    }
}
