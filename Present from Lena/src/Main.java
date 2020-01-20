import java.util.Scanner;

public class Main {
	public static void present(int cou,int max){
		for(int i=0;i<cou;i++){
	        System.out.printf("  ");
	    }
		System.out.printf("0");
	    for(int i=1;i<=max;i++){
	    	System.out.printf(" %d",i);
	    }
	    for(int i=max-1;i>=0;i--){
	    	System.out.printf(" %d",i);
	    }
	    System.out.println();
	}
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 0;i <= n;i++){
			present(n-i,i);
		}
		for(int i = n - 1;i >= 0;i--){
			present(n-i,i);
		}
	}
}
