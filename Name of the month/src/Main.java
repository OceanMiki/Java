import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n-- !=0){
			int mon = s.nextInt();
			if(mon == 1)
				System.out.println("Jan");
			else if(mon == 2)
				System.out.println("Feb");
			else if(mon == 3)
				System.out.println("Mar");
			else if(mon == 4)
				System.out.println("Apr");
			else if(mon == 5)
				System.out.println("May");
			else if(mon == 6)
				System.out.println("Jun");
			else if(mon == 7)
				System.out.println("Jul");
			else if(mon == 8)
				System.out.println("Aug");
			else if(mon == 9)
				System.out.println("Sep");
			else if(mon == 10)
				System.out.println("Oct");
			else if(mon == 11)
				System.out.println("Nov");
			else if(mon == 12)
				System.out.println("Dec");
			else 
				System.out.println("Invalid");
		}
	}

}
