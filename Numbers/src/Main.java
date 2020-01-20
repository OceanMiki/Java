import java.util.Scanner;

public class Main {
	public static int Gcd(int m, int n) {
		int result = 0;
		while (n != 0) {
			result = m % n;
			m = n;
			n = result;
		}
		return m;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int ans = 0;
			int n = in.nextInt();
			for (int base = 2; base <= n - 1; base++) {
				int tmp = n;
				while (tmp > 0) {
					ans += tmp % base;
					tmp /= base;
				}
			}
			int a = Gcd(ans, (n - 2));
			System.out.printf("%d/%d\n",ans / a , (n - 2) / a);
		}
		in.close();
	}

}