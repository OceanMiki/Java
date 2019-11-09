import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- != 0) {
			int num = s.nextInt();
			int result = 0;// 存反转的数字
			while (true) {
				int left = num % 10;
				result = result * 10 + left;
				num = num / 10;
				if (num == 0) {
					break;
				}
			}
			System.out.println(result);
		}
		s.close();
	}

}
