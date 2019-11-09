import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		for(int i = 0 ; i < n ; i++ ){
			
			String num = s.nextLine();
			
			if(num.startsWith("-"))    
                num = num.substring(1);
			
			int digit = num.length();
			System.out.print(num.charAt(0));
			
			for( int j = 1; j < digit ;j++){
				int bool = 1;
				for( int k = 0 ;k < j; k++ ){
					if(num.charAt(j) == num.charAt(k)){
						bool = 0;
					}
				}
				if(bool == 1){
					System.out.print(num.charAt(j));
				}
			}

			System.out.print("\n");
		}
		s.close();
	}

}
