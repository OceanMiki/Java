import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		while(n-- != 0){
			double x1 = s.nextDouble();
			double y1 = s.nextDouble();
			double x2 = s.nextDouble();
			double y2 = s.nextDouble();
			double ans = Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2),0.5);
			System.out.printf("%.4f",ans);
			System.out.println();
		}
	}
}
