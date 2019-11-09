import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		while(num-- > 0){
			int n = s.nextInt();
			String line = s.nextLine();
			line = line.substring(1);
			if(n != 0){
				while(n-- > 0){
			       System.out.print(line);
				}
			}
			System.out.print("\n");
		 }

	}
}
