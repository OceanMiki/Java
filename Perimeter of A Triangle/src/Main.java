import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			Double a = s.nextDouble();
			Double b = s.nextDouble();
			Double c = s.nextDouble();
			int d = c.compareTo(a+b);
			int e = a.compareTo(b+c);
			int f = b.compareTo(a+c);
			
			if(d < 0&& e < 0 &&f < 0){
				System.out.printf("%.2f\n",a+b+c);
			}
			else if((d == 0 &&e <0 && f < 0) ||(d < 0 &&e == 0 && f < 0)||(d < 0 &&e <0 && f == 0)){
				System.out.printf("%.2f degraded triangle\n",a+b+c);
			}
			else{
				System.out.print("Invalid triangle\n");
			}
		}
		s.close();
	}
}