class Person {
	String name;
	Person(String name) {
		this.name = name;
	}
}

class Money {
	double amount;
	Money(double amount) {
		this.amount = amount;
	}
	
	Money(Money money) {
		this.amount = money.amount;
	}
}

class CreditCard {
	Person owner;
	Money balance;
	Money creditLimit;

	CreditCard(Person owner, Money creditLimit) {
		this.owner = owner;
		this.creditLimit = new Money(creditLimit);
		this.balance = new Money(0);
	}

	CreditCard(Person owner, Money creditLimit, Money balance) {
		this.owner = owner;
		this.balance = new Money(balance);
		this.creditLimit = new Money(creditLimit);
	}

	CreditCard(Person owner, double creditLimit, double balance) {
		this.owner = owner;
		this.balance = new Money(balance);
		this.creditLimit = new Money(creditLimit);
	}
	
	void display() {
		System.out.println("Owner: " + owner.name);
		System.out.println("Balance: " + balance.amount);
		System.out.println("Credit Limit: " + creditLimit.amount);
	}
}

public class CreditCardImplementation {
	public static void main (String[] args) {
		Person p = new Person("Harish");
		Money limit = new Money(100000);
		
		CreditCard c1 = new CreditCard(p, limit);
		c1.display();

		System.out.println();

		CreditCard c2 = new CreditCard(p, 5000, 150000);
		c2.display();
	}
}
