import java.util.*;
import java.math.*;

public class Main {
	static int letterToNumber(char letter) {
		int number = letter - 64;
		return number;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (s.hasNext()) {
			String s1 = s.next();
			String s2 = s.next();
			int len1 = s1.length();
			int len2 = s2.length();
			int sum1 = 1;
			int sum2 = 1;
			for (int i = 0; i < len1; i++) {
				int x = letterToNumber(s1.charAt(i));
				sum1 *= x;
			}
			for (int j = 0; j < len2; j++) {
				int y = letterToNumber(s2.charAt(j));
				sum2 *= y;
			}
			if ((sum2 % 47) == (sum1 % 47)) {
				System.out.println("GO");
			} else
				System.out.println("STAY");
		}
		s.close();
	}

}
