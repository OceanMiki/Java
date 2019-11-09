import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		Long num = 0l,sum = 0l;
		
		while(n-- > 0){
			String str = s.nextLine();
			if(str.charAt(0) =='+'){
				num++;
			}
			else if(str.charAt(0) == '-'){
				num--;
			}
			else{
				for(int i = 0;i < str.length(); i++){
					if(str.charAt(i) == ':'){
						sum+=num*(str.length()-1-i);
						break;
					}
				}
			}
			
		}
		System.out.println(sum);
		s.close();
	}
}
