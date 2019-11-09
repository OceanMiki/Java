import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		double a = s.nextDouble();
		double b = s.nextDouble();
		double c = s.nextDouble();
		if(b*b-4*a*c < 0){
			System.out.println("The equation has no real roots");
		}
		else if(b*b-4*a*c == 0){
			double ans = (-b)/(2*a);
			System.out.println(String.format(".6f", ans));
		}
		else{
			double ans1 = (-b + Math.pow(b*b - 4*a*c,0.5))/(2*a);
			double ans2 = (-b - Math.pow(b*b - 4*a*c,0.5))/(2*a);
			System.out.print(String.format("%.6f", ans1)+" ");
			System.out.println(String.format("%.6f", ans2));
		}
	}
}
