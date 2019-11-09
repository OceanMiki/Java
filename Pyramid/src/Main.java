import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt();
			while(n > 0){
				for(int i = n;i > 0;i--){
					System.out.print(i+" ");
				}
				for(int j = 2;j < n;j++){
					System.out.print(j+" ");
				}
				if(n!=1){
				System.out.println(n);
				}
				n--;
			}
		}
		s.close();
	}
}
