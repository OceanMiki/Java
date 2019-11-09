import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int p1 = s.nextInt();
		int p2 = s.nextInt();
		int p3 = s.nextInt();
		int t1 = s.nextInt();
		int t2 = s.nextInt();
		int a[] = new int[n+1];
		int b[] = new int[n+1];
		int now = 0,sum = 0,x = 0;
		
		for(int i =0;i < n;i++){
			a[i] = s.nextInt();
			b[i] = s.nextInt();
			if(x > 0){
				now = a[i]-x;
				if(now <= t1)
					sum += now*p1;
				else if(now <= t1+t2)
					sum += t1*p1+(now-t1)*p2;
				else
					sum += t1*p1+t2*p2+(now-t1-t2)*p3;
			}
 
			now = b[i] - a[i];
			sum += now*p1;
 
			x = b[i];
		}
		System.out.println(sum);
	}
}
