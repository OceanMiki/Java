import java.util.Scanner;
public class Main{
public static void main(String []args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String str = s.nextLine();
			StringBuilder sb=new StringBuilder(str);
			sb.reverse();
			String newStr=new String(sb);
			if(str.equals(newStr)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
		}
}