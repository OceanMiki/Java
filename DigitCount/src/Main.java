import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {

			long num = s.nextLong();
			int count=1;
			
			while(num/10 != 0){
				count++;
				num/=10;
			}
			
			System.out.println(count);
		}
	}

}
