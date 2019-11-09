
/* PRESET CODE BEGIN - NEVER TOUCH CODE BELOW */

import java.util.Scanner;

class Account {
	private double balance;

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

	SavingsAccount Protect_by;

	public CheckingAccount(double init_balance) {
		super(init_balance);
		Protect_by = null;
	}

	public CheckingAccount(double init_balance, SavingsAccount protect) {
		super(init_balance);
		Protect_by = protect;
	}

	public boolean withdraw(double ant) {
		if (this.getBalance() - ant >= 0) {
			super.withdraw(ant);
			return true;
		} else {
			if (Protect_by == null) {
				return false;
			} else {
				double cha = ant - this.getBalance();
				super.withdraw(this.getBalance());
				if (Protect_by.getBalance() - cha >= 0) {
					Protect_by.withdraw(cha);
					return true;
				} else {
					return false;
				}
			}
		}

	}
}

class Customer {
	private String firstName;
	private String lastName;
	private CheckingAccount checkingaccount;
	private SavingsAccount savingsaccount;

	public Customer(String f, String l) {
		firstName = f;
		lastName = l;
		checkingaccount = null;
		savingsaccount = null;
	}

	public String toString() {
		return ("[" + lastName + ", " + firstName + "]");
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

class Main {

	public static void main(String[] args) {

		Bank bank = new Bank();

		Customer customer;
		Account account;

		int curCustomer = 0;
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		while (t-- > 0) {
			String f = s.next();
			String l = s.next();
			s.nextLine();
			bank.addCustomer(f, l);
			customer = bank.getCustomer(curCustomer++);
			int numAccount = s.nextInt();
			s.nextLine();
			while (numAccount-- > 0) {
				String[] type = s.nextLine().split(" ");
				double balance;
				boolean protectWithSavings;
				char op = type[0].charAt(0);
				if (op == 'C' || op == 'c') {
					balance = Double.parseDouble(type[1]);
					protectWithSavings = Boolean.parseBoolean(type[2]);
					if (protectWithSavings) {
						customer.setChecking(new CheckingAccount(balance, customer.getSavings()));
						System.out.println(customer + " create Checking account: " + customer.getChecking().getBalance()
								+ " with a protecting savings accout: " + customer.getSavings().getBalance());
					} else {
						customer.setChecking(new CheckingAccount(balance));
						System.out.println(customer + " create Checking account: " + customer.getChecking().getBalance()
								+ " without protecting savings accout.");
					}
				} else if (op == 'S' || op == 's') {
					balance = Double.parseDouble(type[1]);
					double interestRate = Double.parseDouble(type[2]);
					customer.setSavings(new SavingsAccount(balance, interestRate));
					System.out.println(customer + " create savings account: " + customer.getSavings().getBalance());
				}
			}
		}

		int nOPs = s.nextInt();
		s.nextLine();
		while (nOPs-- > 0) {
			String[] sOP = s.nextLine().split(" ");
			char op = sOP[0].charAt(0);
			int customerIndex = Integer.parseInt(sOP[1]);
			double amount = Double.parseDouble(sOP[2]);
			boolean result;
			switch (op) {
			case 'w':
			case 'W':
				customer = bank.getCustomer(customerIndex);
				result = customer.getChecking().withdraw(amount);
				System.out.println("Checking acct " + customer + "withdraw " + amount + " succeeds? " + result);
				break;
			case 'd':
			case 'D':
				customer = bank.getCustomer(customerIndex);
				result = customer.getChecking().deposit(amount);
				System.out.println("Checking acct " + customer + "deposit " + amount + " succeeds? " + result);
				break;
			}
		}

		// Generate a report
		for (int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++) {
			customer = bank.getCustomer(cust_idx);

			System.out.println();
			System.out.println("Customer: " + customer.getLastName() + ", " + customer.getFirstName());

			account = customer.getChecking();
			System.out.println("    has a checking balance of " + account.getBalance());
			account = customer.getSavings();
			if (account != null)
				System.out.println("    has a savings balance of " + account.getBalance());
		}
	}
}

/* PRESET CODE END - NEVER TOUCH CODE ABOVE */
