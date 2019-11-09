import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[4];
		while(n-- > 0){
			for(int i = 0 ;i < 4; i++){
				a[i] = s.nextInt();
			}
			Arrays.sort(a);
			if(a[0] + a[1] > a[2] || a[1] + a[2] > a[3]){
	             System.out.printf("TRIANGLE\n");
	             continue;
	        }
	        else if(a[0] + a[1] == a[2] || a[1] + a[2] == a[3]){
	        	System.out.printf("SEGMENT\n");
	            continue;
	        }
	        else
	        	System.out.printf("IMPOSSIBLE\n");
		}
		s.close();
	}
}