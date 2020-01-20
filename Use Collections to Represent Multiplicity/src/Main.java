import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Customer {
	private ArrayList<Account> Accounts;
	private String firstName;
	private String lastName;
	private int numberOfCustomers = 0;

	public Customer(String f, String l) {
		firstName = f;
		lastName = l;
		Accounts = new ArrayList<Account>();

	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Account getAccount(int alndex) {
		return Accounts.get(alndex);
	}

	public void addAccount(Account acc) {

		Accounts.add(acc);

	}

	public int getNumOfAccounts() {
		numberOfCustomers = Accounts.size();
		return numberOfCustomers;
	}

	@Override
	public String toString() {
		return "[" + firstName + " " + lastName + "]";

	}

}

class Bank {

	private ArrayList<Customer> customers;
	private int numberOfCustomers = 0;
	private static Bank bankInstance = new Bank();

	public static Bank getBank() {
		return bankInstance;
	}

	private Bank() {
		customers = new ArrayList<Customer>();
	}

	public void addCustomer(String f, String l) {
		Customer C = new Customer(f, l);
		customers.add(C);
	}

	public int getNumOfCustomers() {
		numberOfCustomers = customers.size();
		return this.numberOfCustomers;
	}

	public Customer getCustomer(int index) {

		return customers.get(index);

	}
}

class Account {
	protected double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;

	}

	public void withdraw(double amt) throws OverdraftException {
		if (balance < amt) {
			throw new OverdraftException("Insufficient funds", amt - balance);
		}

		balance = balance - amt;

	}

	public boolean deposit(double amt) {
		balance = balance + amt;
		return true;
	}
}

class SavingsAccount extends Account {
	private double interestRate = 0.0;

	public SavingsAccount(double balance, double interest_rate) {
		super(balance);
		this.interestRate = interest_rate;

	}

}

class CheckingAccount extends Account {
	private double overdraftProtection;

	public CheckingAccount(double balance) {
		super(balance);
	}

	public CheckingAccount(double balance, double protect) {
		super(balance);
		this.overdraftProtection = protect;
	}

	public void withdraw(double amt) throws OverdraftException {
		if (amt > balance + overdraftProtection) {
			if (overdraftProtection == 0) {
				throw new OverdraftException("No overdraft protection", amt - balance);
			} else {
				throw new OverdraftException("Insufficient funds", amt - balance - overdraftProtection);
			}
		}
		if (amt > balance) {
			overdraftProtection = balance + overdraftProtection - amt;
			amt = balance;
		}
		super.withdraw(amt);
	}

}

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
			System.out.println("Customer: " + "[" + customer.getFirstName() + " " + customer.getLastName() + "]");

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
				System.out.print("    " + account_type + ": current balance is ");
				System.out.println("$" + account.getBalance());
			}
		}
	}
}

class OverdraftException extends Exception {
	private static final long serialVersionUID = 1L;
	private double deficit;

	public OverdraftException(String message, double deficit) {
		super(message);
		this.deficit = deficit;
	}

	public double getDeficit() {
		return deficit;
	}
}

public class Main {  
	  
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
                if (type[0].trim().toUpperCase().equals("C")) {  
                    balance = Double.parseDouble(type[1]);  
                    if (type.length == 3) {  
                        interesOrProtect = Double.parseDouble(type[2]);  
                        customer.addAccount(new CheckingAccount(balance,  
                                interesOrProtect));  
                    } else {  
                        customer.addAccount(new CheckingAccount(balance));  
                    }  
                } else if (type[0].trim().toUpperCase().equals("S")) {  
                    balance = Double.parseDouble(type[1]);  
                    interesOrProtect = Double.parseDouble(type[2]);  
                    customer.addAccount(new SavingsAccount(balance,  
                            interesOrProtect));  
                }  
            }  
        }  
  
        int nOPs = s.nextInt();  
        s.nextLine();  
        while (nOPs-- > 0) {  
            String[] sOP = s.nextLine().split(" ");  
            char op = sOP[0].charAt(0);  
            int customerIndex = Integer.parseInt(sOP[1]);  
            int accountIndex = Integer.parseInt(sOP[2]);  
            double amount = Double.parseDouble(sOP[3]);  
            switch (op) {  
            case 'w':  
            case 'W':  
                customer = bank.getCustomer(customerIndex);  
                try{  
                    customer.getAccount(accountIndex).withdraw(amount);  
                }  
                catch (OverdraftException ode){  
                    System.out.println( customer + " withdraw " + amount + ", " + ode.getMessage() + ": " + ode.getDeficit());  
                }  
                break;  
            case 'd':  
            case 'D':  
                customer = bank.getCustomer(customerIndex);  
                customer.getAccount(accountIndex).deposit(amount);  
                break;  
            }  
        }  
  
        // Generate a report  
        CustomerReport cr = new CustomerReport();  
        cr.generateReport(); 
        s.close();
    }  
}  
