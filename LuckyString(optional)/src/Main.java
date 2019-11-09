import java.util.*;

public class Main {
	public static void isLucky(int n){
		int counter=0;
		for(int i = 0;i < n;i++)
		{
			System.out.printf("%c",'a'+counter);
			counter=(counter+1)%4;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- > 0) {
			int num = s.nextInt();
			isLucky(num);
		}
	}
}
