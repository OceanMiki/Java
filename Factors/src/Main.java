import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int num = s.nextInt();
			for (int i = 2; i <= num; i++) {
				while (num % i == 0) {
					num /= i;

					if (num != 1) {
						System.out.print(i + " ");
					} else {
						System.out.println(i);
					}
				}
			}
		}
	}
}
