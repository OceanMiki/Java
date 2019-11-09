import java.util.*;

public class Main {
	public static void pr(int n){
		for(int i = 0; i < n ; i++ ){
			for(int j = 0 ;j < n;j++){
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		pr(n);
		for(int i = 0; i < 2*n+1 ; i++ ){
			System.out.print("*");
		}
		System.out.println();
		pr(n);
	}
}
