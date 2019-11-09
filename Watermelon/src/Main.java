import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		while(n-- >0){
			int kilo = s.nextInt();
			if(kilo%2 != 0 || kilo == 2){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
		s.close();
	}
}