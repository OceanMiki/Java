import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		
		for (int i = 0; i < n; i++) {

			String num = s.nextLine();

			if (num.startsWith("-"))
				num = num.substring(1);
			
			int sum = 0;
			int digit = num.length();
			for( int j = 0 ;j < digit ;j++ ){
				int count = num.charAt(j)-'0';
				sum+=count;
			}
			
			System.out.println(sum);

		}
		s.close();

	}
}
