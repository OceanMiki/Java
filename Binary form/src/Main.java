import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		BigInteger x1 = new BigInteger("-1");
		BigInteger x2 = new BigInteger("-20");
		while(n-- != 0){
			  int num = s.nextInt();
	          System.out.println(Integer.toBinaryString(num));
		}
		s.close();
	}

}
