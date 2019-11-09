import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n-- > 0){
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			int  d = s.nextInt();
			int count = 0;
			for(int i = (x1+x2)/2+d ; i >= (x1+x2)/2-d; i-- ){
				for(int j =(y1+y2)/2+d ; j >= (y1+y2)/2-d; j-- ){
					if(Math.sqrt(Math.pow(i-x1, 2)+Math.pow(j-y1, 2))+Math.sqrt(Math.pow(i-x2, 2)+Math.pow(j-y2, 2))<d){
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
}
