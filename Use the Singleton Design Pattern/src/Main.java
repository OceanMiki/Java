import java.text.NumberFormat;
import java.util.*;

class CustomerReport {

	public void generateReport() {
		NumberFormat currency_format = NumberFormat.getCurrencyInstance();

		Bank bank = Bank.getBank();

		Customer customer;

		System.out.println("CUSTOMERS REPORT");
		System.out.println("================");

		for (int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++) {
			customer = bank.getCustomer(cust_idx);

			System.out.println();
			System.out.println("Customer: " + customer.getLastName() + ", " + customer.getFirstName());

			for (int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++) {
				Account account = customer.getAccount(acct_idx);
				String account_type = "";

				// Determine the account type
				if (account instanceof SavingsAccount) {
					account_type = "Savings Account";
				} else if (account instanceof CheckingAccount) {
					account_type = "Checking Account";
				} else {
					account_type = "Unknown Account Type";
				}

				// Print the current balance of the account
				System.out.println(
						"    " + account_type + ": current balance is " + currency_format.format(account.getBalance()));
			}
		}
	}

}

class SavingsAccount extends Account {
	private double interesOrProtect;

	public SavingsAccount(double balance, double iop) {
		super(balance);
		interesOrProtect = iop;
	}
}

class CheckingAccount extends Account {
	private double interesOrProtect;

	public CheckingAccount(double balance) {
		super(balance);
	}

	public CheckingAccount(double balance, double iop) {
		super(balance);
		interesOrProtect = iop;
	}
}

class Customer {
	private String firstName, lastName;
	Account[] account = new Account[3];
	private int num = 0;

	public Customer(String f, String l) {
		firstName = f;
		lastName = l;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Account getAccount(int index) {
		return account[index];
	}

	public void addAccount(Account acct) {
		account[num] = acct;
		num++;
	}

	public int getNumOfAccounts() {
		return num;
	}
}

class Account {
	protected double Balance;

	public Account(double bal) {
		Balance = bal;
	}

	public double getBalance() {
		return Balance;
	}
}

class Bank {
	private int num;
	private Customer cus[];
	public static Bank bank = new Bank();

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

	public static Bank getBank() {
		return bank;
	}
}

class Main {

	public static void main(String[] args) {
		Bank bank = Bank.getBank();
		Customer customer;
		int curCustomer = 0;
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		// Create several customers and their accounts according to data
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
				double interesOrProtect;
				char op = type[0].charAt(0);
				if (op == 'C' || op == 'c') {
					balance = Double.parseDouble(type[1]);
					if (type.length == 3) {
						interesOrProtect = Double.parseDouble(type[2]);
						customer.addAccount(new CheckingAccount(balance, interesOrProtect));
					} else {
						customer.addAccount(new CheckingAccount(balance));
					}
				} else if (op == 'S' || op == 's') {
					balance = Double.parseDouble(type[1]);
					interesOrProtect = Double.parseDouble(type[2]);
					customer.addAccount(new SavingsAccount(balance, interesOrProtect));
				} else if (op == 'A' || op == 'a') {
					int cIndex = Integer.parseInt(type[1]);
					int aIndex = Integer.parseInt(type[2]);
					customer.addAccount(bank.getCustomer(cIndex).getAccount(aIndex));
				}
			}
		}

		CustomerReport cr = new CustomerReport();
		cr.generateReport();
	}
}
