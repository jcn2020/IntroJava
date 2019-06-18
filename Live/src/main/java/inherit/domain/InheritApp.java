package inherit.domain;

public class InheritApp {
	
	public static void main(String[] args) {
		testMonthEnd();
	}

	public static void testMonthEnd() {
		Account a = new Account("Joe", 600);
		a.monthEnd();
		
		System.out.println("a balance is " + a.getBalance());
		
		CheckingAccount ca = new CheckingAccount("Shanthi", 600);
		ca.withdraw(20);
		System.out.println("ca balance is " + ca.getBalance());
		
		
		Account account = ca;
		account.withdraw(20);
		
		SavingsAccount sa = new SavingsAccount("Cruz", 600);
		sa.monthEnd();
		System.out.println("sa balance is " + sa.getBalance());
		
		
	}
	
	public static void testWithdraw() {
		Account a = new Account("Joe", 600);
		boolean b = a.withdraw(400);
		
		System.out.println("400 from Account is " + b);
		System.out.println("a balance is " + a.getBalance());
		
		CheckingAccount ca = new CheckingAccount("Shanthi", 600);

		boolean b2 = ca.withdraw(400);
		
		System.out.println("ca balance is " + ca.getBalance());
		
		
	}

}
