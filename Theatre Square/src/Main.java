import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		while(num-- > 0){
			long n = s.nextLong();
			long m = s.nextLong();
			long a = s.nextLong();
			Long nx=n/a+(n%a == 0?0:1);
		    Long mx=m/a+(m%a == 0?0:1);
		    System.out.println(nx*mx);
		}
		s.close();
	}
}
