import java.util.*;  
  
public class Main {
	public static String str4 = "444444444444";  
	public static String str7 = "777777777777";
    public static void luckySum(int n) {  
        int s = 0, f = 0;  
        s = n / 7;  
        if (0 == (n - 7 * s) % 4) {  
            f = (n - 7 * s) / 4;  
        } else  
            while (s-- != 0) {  
                if (0 == (n - 7 * s) % 4) {  
                    f = (n - 7 * s) / 4;  
                    break;  
                }  
            }  
        if (0 == n || -1 == s) {  
            System.out.println("-1");  
        } else {      
            System.out.print(str4.substring(0, f));  
            System.out.print(str7.substring(0, s));  
  
            System.out.println();  
        }  
  
    }  
  
    public static void main(String[] args) {  
        Scanner s = new Scanner(System.in);  
        int n = s.nextInt();
        for (int j = 0; j < 20; j++) {  
            str4 = str4 + str4;  
        }  
        for (int j = 0; j < 20; j++) {  
            str7 = str7 + str7;  
        }
        while (n-- > 0) {  
            int sum = s.nextInt();  
            luckySum(sum);  
        }  
        s.close();  
    }  
} 