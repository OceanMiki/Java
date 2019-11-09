import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		
		for (int i = 0; i < n; i++) {

			String num = s.nextLine();
			
			System.out.println(num.length());

		}
		s.close();

	}
}

