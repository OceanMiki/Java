import java.util.Scanner;
public class Main {
	public static boolean isC(String str){
		String regex = "\\d{3}-\\d{2}-\\d{4}";

		return str.matches(regex);
	}
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String str = s.nextLine();
			if(isC(str)){
				System.out.println("YES");
			}
			else
				System.out.println("NO");
		}
	}
}