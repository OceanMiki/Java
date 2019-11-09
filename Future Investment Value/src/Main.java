import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
		double a = s.nextDouble();
		double b = s.nextDouble();
		int c = s.nextInt();
		double m = b/1200;
		System.out.printf("%.2f\n",a*Math.pow(1.0+m,c*12));
		}
		s.close();
	}
}