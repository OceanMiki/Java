import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		if(n %2 == 0 && n %3 == 0){
			System.out.printf("%d is divisible by 2 and 3.\n",n);
		}
		if(n %2 == 0 || n %3 == 0){
			System.out.printf("%d is divisible by 2 or 3.\n",n);
		}
		if(n %6 !=0){
			System.out.printf("%d is divisible by 2 or 3, but not both.\n",n);
		}
	}
}
