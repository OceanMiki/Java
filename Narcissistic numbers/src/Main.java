import java.util.*;
import java.math.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		double n = s.nextDouble();
		int flag = 0;
		for(int i =(int)Math.pow(10.0, n-1.0) ;i < Math.pow(10.0, n);i++){
			int sum = 0;
			int k = i;
			while(k != 0){
				int j = k%10;
				sum +=Math.pow(j, n);
				k = k/10;
			}
			if(sum == i && flag == 0){
				System.out.print(i);
				flag = 1;
			}
			else if(sum == i && flag == 1)
				System.out.print(" "+i);
		}
		if(flag == 0){
			System.out.println("No");
		}
		else
			System.out.println();
	}

}
