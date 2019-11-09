import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Long a = s.nextLong();
		Long b = s.nextLong();
		int carry,c;
		while(a+b != 0){
			carry = c = 0;
			while (a!=0 || b!=0) 
			{
				c = (a % 10 + b % 10 + c) > 9 ? 1 : 0;
				carry += c;
				a /= 10;
				b /= 10;
			}
			if (carry == 0)
				System.out.println("No carry operation.");
			else if (carry == 1)
				System.out.println("1 carry operation.");
			else
				System.out.printf("%d carry operations.\n", carry);
			a = s.nextLong();
			b = s.nextLong();
		}
	}
}