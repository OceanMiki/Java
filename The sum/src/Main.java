import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int count = 1;

		while (n-- != 0) {
			int a = s.nextInt();
			int b = s.nextInt();
			System.out.printf("Case %d: ",count);
			count++;
			if (a <= b) {
				long sum = 0;
				for (int i = a; i <= b; i++) {
					sum += i;
				}
				System.out.println(sum);
			} else
				System.out.println();
		}
		s.close();
	}

}
