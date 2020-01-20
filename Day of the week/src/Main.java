import java.util.Scanner;
public class Main{
public static void main(String []args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int y = s.nextInt();
			int m = s.nextInt();
			int q = s.nextInt();
			int j = y/100;
			int k = y%100;
			if(m==1){
				m=13;
			}
			if(m==2){
				m=14;
			}
			int h = (int)(q+26*(m+1)/10+k+k/4+j/4+5*j)%7;
			if(h == 0){
				System.out.println("Saturday");
			}
			if(h == 1){
			System.out.println("Sunday");
			}
			if(h == 2){
				System.out.println("Monday");
			}
			if(h == 3){
			System.out.println("Tuesday");
			}
			if(h == 4){
				System.out.println("Wednesday");
			}
			if(h == 5){
			System.out.println("Thursday");
			}
			if(h == 6){
				System.out.println("Friday");
				}
		}
}
}