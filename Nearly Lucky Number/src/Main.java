import java.util.*;

public class Main {
	
	public static void isNearLucky(String num){
        int count = 0;
		for(int i = 0;i < num.length(); i++){
			if(num.charAt(i) == '4' || num.charAt(i) == '7'){
				count++;
			}
		}
		System.out.println((count == 4||count == 7)?"YES":"NO");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		s.nextLine();
		while (n-- > 0) {
			String num = s.nextLine();
			isNearLucky(num);
		}
		s.close();
	}

}