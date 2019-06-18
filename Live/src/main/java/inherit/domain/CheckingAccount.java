package inherit.domain;

public class CheckingAccount extends Account {
	
	private double minBalance = 500;
	
	public CheckingAccount(String name, double initialAmount) {
		super(name, initialAmount);
	}
	
	@Override
	public boolean withdraw(double amt) {
		if( getBalance() > amt + minBalance) {
			return super.withdraw(amt);
		}
		
		return false;
	}
	
	public void foo() {
		
	}

}
