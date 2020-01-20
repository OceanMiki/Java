import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String ans = s.nextLine();
		boolean b = ans.length() == str.length()? true : false;
		int count = 0;
		for(int i = 0; i< str.length();i++){
			if(str.charAt(i) == '0'){
				count++;
			}
		}
		str = str.replaceAll("0","");
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0;i < str.length();i++){
			arr.add(str.charAt(i)-48);
		}
		Collections.sort(arr);
		for(int i = 1;i < count+1;i++){
			arr.add(i, 0);
		}
		int flag = 1;
		if(b){
			for(int i = 0;i < str.length();i++){
				if(arr.get(i) != ans.charAt(i)-48){
					flag = 0;
					break;
				}
			}
			
		}
		if(flag == 1 && b){
			System.out.println("OK");
		}else{
			System.out.println("WRONG_ANSWER");
		}
	}
}
