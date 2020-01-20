import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		int max = 1002;
		int min = -1;
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			max = max < Math.max(a, b) ? max : Math.max(a, b);
			min = min > Math.min(a, b) ? min : Math.min(a, b);
		}
		if (max < min) {
			System.out.println("-1");
		} else {
			if(x < min){
				System.out.println(min-x);
			}
			else if(x > max){
				System.out.println(x-max);
			}
			else{
				System.out.println("0");
			}
		}
		s.close();
	}
}