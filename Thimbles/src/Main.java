import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n-- > 0){
			int[] pot = {0,1,2,3};
			int num = s.nextInt();
			while(num-- > 0){
				String swap = s.next();
				int a = (int)swap.charAt(0)-48;
				int b = (int)swap.charAt(2)-48;
				int x = 0 , y = 0;
				for( int i = 1 ; i <= 3 ; i++ ){
					if(a == pot[i]){
						x = i;
					}
				}
				for( int j = 1 ; j <= 3 ; j++ ){
					if(b == pot[j]){
						y = j;
					}
				}
				int c = pot[x];
				pot[x] = pot[y];
				pot[y] = c;
			}
			System.out.println(pot[1]);
		}
		s.close();
	}
}
