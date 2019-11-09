import java.util.Scanner;
import java.text.NumberFormat;

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
		NumberFormat currency_format = NumberFormat.getCurrencyInstance();
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
				if (type[0].compareTo("C") == 0 || type[0].compareTo("c") == 0) {
					balance = Double.parseDouble(type[1]);
					if (type.length == 3) {
						interesOrProtect = Double.parseDouble(type[2]);
						customer.addAccount(new CheckingAccount(balance, interesOrProtect));
					} else {
						customer.addAccount(new CheckingAccount(balance));
						interesOrProtect = Double.parseDouble(type[1]);
					}
				} else if (type[0].compareTo("S") == 0 || type[0].compareTo("s") == 0) {
					balance = Double.parseDouble(type[1]);
					interesOrProtect = Double.parseDouble(type[2]);
					customer.addAccount(new SavingsAccount(balance, interesOrProtect));
				} else if (type[0].compareTo("A") == 0 || type[0].compareTo("a") == 0) {
					int cIndex = Integer.parseInt(type[1]);
					int aIndex = Integer.parseInt(type[2]);
					customer.addAccount(bank.getCustomer(cIndex).getAccount(aIndex));
				}
			}
		}

		// Generate a report
		System.out.println("CUSTOMERS REPORT");
		System.out.println("================");

		for (int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++) {
			customer = bank.getCustomer(cust_idx);

			System.out.println();
			System.out.println("Customer: " + customer.getLastName() + ", " + customer.getFirstName());

			for (int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++) {
				Account account = customer.getAccount(acct_idx);
				String account_type = "";
				if (account instanceof SavingsAccount) {
					account_type = "Savings Account";
				} else {
					account_type = "Checking Account";
				}
				System.out.println("    " + account_type + currency_format.format(account.getBalance()));
			}
		}
		s.close();
	}
}