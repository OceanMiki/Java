import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- != 0) {
			int a = s.nextInt();
			int b = s.nextInt();
			String str = s.nextLine();
			int len = str.length();
			if (a > b || b > len)
				System.out.println("-1");
			else
				System.out.println(str.substring(a + 1, b + 2));
		}
	}
}
