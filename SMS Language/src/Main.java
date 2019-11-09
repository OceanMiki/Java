import java.util.*;

public class Main {

public static String format(String s){ 
		String str = s.toLowerCase();
		str = str.replace(",", "");
		str = str.replace(".", "");
		str = str.replace("?", "");
		str = str.replace("!", "");
		str = str.replace("ate", "8");
		str = str.replace("at", "@");
		str = str.replace("and", "&");
		str = str.replace("you", "U");
		return str; 
	}

	public static void main(String[] args){
		Scanner s  = new Scanner(System.in );
		int n = s.nextInt();
		s.nextLine();
		while(n-- != 0){
			String str = s.nextLine();
			System.out.println(format(str));
		}
		s.close();
	}

}
