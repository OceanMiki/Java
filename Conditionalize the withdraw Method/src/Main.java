
class Account{
	double balance;
	boolean withdraw(double w){
		if(w > balance)
			return false;
		else{
			balance-=w;
			return true;
		}
	}
	boolean deposit(double d){
		balance+=d; 
		return true;
	}
	double getBalance(){
		return balance;
	}
	Account(double b){
		this.balance = b;
	}
}

class Customer{
	String last,first;
	Account acc;
	Customer(String f,String l){
		this.first = f;
		this.last = l;
	}
	void setAccount(Account account){
		acc = account;
	}
	Account getAccount(){
		return acc;
	}
	String getLastName(){
		return last;
	}
	String getFirstName(){
		return first;
	}
}

  
public class Main{  
  
  public static void main(String[] args) {  
    Customer customer;  
    Account  account;  
  
    // Create an account that can has a 500.00 balance.  
    System.out.println("Creating the customer Jane Smith.");  
    customer = new Customer("Jane", "Smith");  
    System.out.println("Creating her account with a 500.00 balance.");  
    customer.setAccount(new Account(500.00));  
    account = customer.getAccount();  
  
    // Perform some account transactions  
    System.out.println("Withdraw 150.00: " + account.withdraw(150.00));  
    System.out.println("Deposit 22.50: " + account.deposit(22.50));  
    System.out.println("Withdraw 47.62: " + account.withdraw(47.62));  
    System.out.println("Withdraw 400.00: " + account.withdraw(400.00));  
  
    // Print out the final account balance  
    System.out.println("Customer [" + customer.getLastName()  
               + ", " + customer.getFirstName()  
               + "] has a balance of " + account.getBalance());  
  }  
}  
  
/* PRESET CODE END - NEVER TOUCH CODE ABOVE */
