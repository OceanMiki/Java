
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
	public static boolean isNumeric(String str) {  
        Pattern pattern = Pattern.compile("[0-9]*");  
        Matcher isNum = pattern.matcher(str);  
        if (!isNum.matches()) {  
            return false;  
        }  
        return true;  
    }
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		while(s.hasNext()){
			String str = s.nextLine();
			int sum = 0;
			int flag = 1;
			if(isNumeric(str)&&str.length() == 12){
				for(int i = 0;i < 12; i++){
					if(i%2==1){
						flag = 3;
					}
					sum+=flag*Integer.valueOf(str.charAt(i)-'0');
					
					flag = 1;
				}
				int d13 =10 - sum%10;
				if(d13 == 10){
					d13 = 0;
				}
				System.out.println(str+""+d13);
			}else{
				System.out.println("Invalid");
			}
			
		}
	}
}
