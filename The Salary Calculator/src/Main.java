import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n-- != 0){
			double p1 = s.nextDouble();
			double p2 = s.nextDouble();
			double salary = s.nextDouble();
			double ans = 0;
			if(p1*200 >= salary){
				ans = salary/p1;
				System.out.println(String.format("%.4f", ans));
			}
			else{
				ans = ((salary-p1*200)/p2)+200;
				System.out.println(String.format("%.4f", ans));
			}
		}
	}
}
