import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		while (n-- > 0) {
			int a = s.nextInt();
			int b = s.nextInt();
			if (a > b) {
				System.out.println();
			} else {
				for (int i = a; i <= b; i++) {
					System.out.print(i);
					if(i % 3 == 0)
						System.out.print(" foo");
					if(i % 5 == 0)
						System.out.print(" bar");
					if(i % 7 == 0)
						System.out.print(" baz");
					
					System.out.println();
						
				}
			}

		}
	}
}
