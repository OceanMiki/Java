import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		double flag = 1.18;
		while(n-- != 0){
			String product = s.next();
			int price = s.nextInt();
			int num = s.nextInt();
			while (num-- != 0){
				String element = s.next();
				if(product.equals(element))
					flag = 1.1;
			}
			System.out.printf("%.2f\n",price*flag);
			flag = 1.18;
		}
	}
}
