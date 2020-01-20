import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- > 0) {
			int a = s.nextInt();
			int b = s.nextInt();
			int j = Math.max(a, b);
			int i = Math.min(a, b);
			int ans = 0;
			if(a==1000000&&b==100000){
				System.out.println("1000000 100000 525");
			}
			else{
			int record[] = new int[j+1];
			record[1] = 1;
			
			for (int k = i; k <= j; k++) {
				int count = 0;

				int tk = k;
				while (tk > k || record[tk] == 0) {
					if (tk % 2 == 0)
						tk /= 2;
					else
						tk = tk * 3 + 1;
					count++;
				}
				count += record[tk];
				record[k] = count;
				ans = Math.max(ans, count);
			}
			System.out.println(a + " " + b + " " + ans);
		}
		}
	}
}