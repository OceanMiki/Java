import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n-- > 0){
			int num = s.nextInt();
			while(num!=1){
				System.out.print(num+",");
				if(num%2 == 1){
					num = num*3 + 1;
				}
				else{
					num/=2; 
				}
			}
			System.out.println("1");
		}
	}
}
