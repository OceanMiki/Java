import java.util.Scanner;
public class Main {
	public static void main (String []args){
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		while(n-- > 0){
			int i = 0;
			int x = s.nextInt();
			int sum = 0;
			x = x<0? -x:x;
			while(true){
				sum+=i;
				i++;
				if(sum == x||(sum>x&&(sum-x)%2==0)){
					break;
				}
			}
			System.out.println(i-1);
		}
	}
}
