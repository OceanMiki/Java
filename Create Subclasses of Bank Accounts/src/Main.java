import java.util.Scanner;

class Account {
	protected double balance;

	public Account(double init_balance) {
		balance = init_balance;
	}

	public double getBalance() {
		return balance;
	}

	public boolean deposit(double d) {
		balance += d;
		return true;
	}

	public boolean withdraw(double w) {
		if (w <= balance) {
			balance -= w;
			return true;
		} else
			return false;
	}
}

class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(double init_balance) {
		super(init_balance);
		interestRate = 0;
	}

	public SavingsAccount(double init_balance, double interest_rate) {
		super(init_balance);
		interestRate = interest_rate;
	}
}

class CheckingAccount extends Account {
	private double overdraftProtection = -1;// 透支保护.如果是-1，表示没有透支保护

	public CheckingAccount(double balance) {
		super(balance);
	}

	public CheckingAccount(double init_balance, double overdraftProtection) {
		super(init_balance);
		this.overdraftProtection = overdraftProtection;
	}

	public boolean withdraw(double amt) {
		// 余额足够
		if (balance >= amt) {// 余额 大于 提取额
			balance -= amt;// 余额 减少 提取额
			return true;
		} else {

			if (overdraftProtection == -1) {// 没有透支保护
				return false;
			}

			// 透支保护足够
			if (overdraftProtection >= (amt - balance)) {// 透支保护 大于 提取-余额
				overdraftProtection -= (amt - balance);// 透支保护 减少 差额
				balance = 0;// 余额清零
				return true;
			}
			// 余额不足，且透支保护不足
			else {
				return false;
			}
		}

	}
}

	class Customer {
		private String firstName;
		private String lastName;
		private CheckingAccount checkingaccount;
		private SavingsAccount savingsaccount;
		private Account account;

		public Customer(String f, String l) {
			firstName = f;
			lastName = l;
			checkingaccount = null;
			savingsaccount = null;
		}

		public void setAccount(Account acct) {
			account = acct;
		}

		public Account getAccount() {
			return account;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public CheckingAccount getChecking() {
			return checkingaccount;
		}

		public SavingsAccount getSavings() {
			return savingsaccount;
		}

		public void setChecking(CheckingAccount sc) {
			checkingaccount = sc;
		}

		public void setSavings(SavingsAccount ss) {
			savingsaccount = ss;
		}
	}

	class Bank {
		private int num;
		private Customer cus[];

		public Bank() {
			num = 0;
			cus = new Customer[100];
		}

		public void addCustomer(String f, String l) {
			cus[num] = new Customer(f, l);
			num++;
		}

		public int getNumOfCustomers() {
			return num;
		}

		public Customer getCustomer(int index) {
			return cus[index];
		}
	}

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Customer customer;
		Account account;

		//
		// Create bank customers and their accounts
		//

		System.out.println("Creating the customer Jane Smith.");
		bank.addCustomer("Jane", "Simms");
		customer = bank.getCustomer(0);
		System.out.println("Creating her Savings Account with a 500.00 balance and 3% interest.");
		customer.setAccount(new SavingsAccount(500.00, 0.03));

		System.out.println("Creating the customer Owen Bryant.");
		bank.addCustomer("Owen", "Bryant");
		customer = bank.getCustomer(1);
		System.out.println("Creating his Checking Account with a 500.00 balance and no overdraft protection.");
		customer.setAccount(new CheckingAccount(500.00));

		System.out.println("Creating the customer Tim Soley.");
		bank.addCustomer("Tim", "Soley");
		customer = bank.getCustomer(2);
		System.out.println("Creating his Checking Account with a 500.00 balance and 500.00 in overdraft protection.");
		customer.setAccount(new CheckingAccount(500.00, 500.00));

		System.out.println("Creating the customer Maria Soley.");
		bank.addCustomer("Maria", "Soley");
		customer = bank.getCustomer(3);
		System.out.println("Maria shares her Checking Account with her husband Tim.");
		customer.setAccount(bank.getCustomer(2).getAccount());

		System.out.println();

		//
		// Demonstrate behavior of various account types
		//

		// Test a standard Savings Account
		System.out.println("Retrieving the customer Jane Smith with her savings account.");
		customer = bank.getCustomer(0);
		account = customer.getAccount();
		// Perform some account transactions
		System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
		System.out.println("Deposit 22.50: " + account.deposit(22.50));
		System.out.println("Withdraw 47.62: " + account.withdraw(47.62));
		System.out.println("Withdraw 400.00: " + account.withdraw(400.00));
		// Print out the final account balance
		System.out.println("Customer [" + customer.getLastName() + ", " + customer.getFirstName()
				+ "] has a balance of " + account.getBalance());

		System.out.println();

		// Test a Checking Account w/o overdraft protection
		System.out
				.println("Retrieving the customer Owen Bryant with his checking account with no overdraft protection.");
		customer = bank.getCustomer(1);
		account = customer.getAccount();
		// Perform some account transactions
		System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
		System.out.println("Deposit 22.50: " + account.deposit(22.50));
		System.out.println("Withdraw 47.62: " + account.withdraw(47.62));
		System.out.println("Withdraw 400.00: " + account.withdraw(400.00));
		// Print out the final account balance
		System.out.println("Customer [" + customer.getLastName() + ", " + customer.getFirstName()
				+ "] has a balance of " + account.getBalance());

		System.out.println();

		// Test a Checking Account with overdraft protection
		System.out
				.println("Retrieving the customer Tim Soley with his checking account that has overdraft protection.");
		customer = bank.getCustomer(2);
		account = customer.getAccount();
		// Perform some account transactions
		System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
		System.out.println("Deposit 22.50: " + account.deposit(22.50));
		System.out.println("Withdraw 47.62: " + account.withdraw(47.62));
		System.out.println("Withdraw 400.00: " + account.withdraw(400.00));
		// Print out the final account balance
		System.out.println("Customer [" + customer.getLastName() + ", " + customer.getFirstName()
				+ "] has a balance of " + account.getBalance());

		System.out.println();

		// Test a Checking Account with overdraft protection
		System.out.println("Retrieving the customer Maria Soley with her joint checking account with husband Tim.");
		customer = bank.getCustomer(3);
		account = customer.getAccount();
		// Perform some account transactions
		System.out.println("Deposit 150.00: " + account.deposit(150.00));
		System.out.println("Withdraw 750.00: " + account.withdraw(750.00));
		// Print out the final account balance
		System.out.println("Customer [" + customer.getLastName() + ", " + customer.getFirstName()
				+ "] has a balance of " + account.getBalance());

	}
}

/* PRESET CODE END - NEVER TOUCH CODE ABOVE */
