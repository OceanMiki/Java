import java.util.Scanner;
import java.math.*;

public class Main {
	static String getPrettyNumber(String number) {
		return BigDecimal.valueOf(Double.parseDouble(number)).stripTrailingZeros().toPlainString();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String ch = s.next();
			double a = s.nextDouble();
			double b = s.nextDouble();
			if (ch.equals("+")) {
				String ans = "" + (a + b);
				System.out.println(getPrettyNumber(ans));
			} else if (ch.equals("-")) {
				String ans = "" + (a - b);
				System.out.println(getPrettyNumber(ans));
			} else if (ch.equals("*")) {
				String ans = "" + (a * b);
				System.out.println(getPrettyNumber(ans));
			} else if (ch.equals("/")) {
				if (b == 0) {
					System.out.println("Invalid");
				} else {
					String ans = "" + (a / b);
					System.out.println(getPrettyNumber(ans));
				}
			} else if (ch.equals("%")) {
				String ans = "" + (a % b);
				if (b == 0)
					System.out.println("Invalid");
				System.out.println(getPrettyNumber(ans));
			} else if (ch.equals("^")) {
				String ans = "" + (Math.pow(a, b));
				System.out.println(getPrettyNumber(ans));
			} else if (ch.equals("1"))
				System.out.println("Invalid");
		}
	}
}