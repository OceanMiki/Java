import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		while(n-- != 0){
			  double f = s.nextDouble();
	          double c = (5*(f-32))/9;
	          System.out.printf("%.2f",c);
	          System.out.println();
		}
		s.close();
	}

}
