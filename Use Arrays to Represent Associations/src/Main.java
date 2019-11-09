/* PRESET CODE BEGIN - NEVER TOUCH CODE BELOW */  
  
import java.util.Scanner;  

class Bank{
	private int num;
	private Customer cus[];
	public Bank(){
		num = 0;
		cus = new Customer[100];
	}
	public void addCustomer(String f,String l){
		cus[num] = new Customer(f,l);
		num++;
	}
	public int getNumOfCustomers(){
		return num;
	}
	public Customer getCustomer(int index){
		return cus[index];
	}
}

class Customer{
	private String lastName,firstName;
	
	public Customer(String f, String l){
		this.firstName = f;
		this.lastName = l;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
}
  
class Main {  
  
    public static void main(String[] args) {  
  
        Bank bank = new Bank();  
          
        Scanner s = new Scanner(System.in);  
        int t = s.nextInt();  
        s.nextLine();  
        while (t-- > 0){  
            String f = s.next();  
            String l = s.next();  
            s.nextLine();  
            bank.addCustomer(f, l);  
        }  
  
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {  
            Customer customer = bank.getCustomer(i);  
  
            System.out.println("Customer [" + (i + 1) + "] is "  
                    + customer.getLastName() + ", " + customer.getFirstName());  
        }  
  
    }  
}  
  
/* PRESET CODE END - NEVER TOUCH CODE ABOVE */  
