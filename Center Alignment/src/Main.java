import java.util.*;  
  
public class Main {  
    public static void main(String[] args) {  
        Scanner s = new Scanner(System.in);  
        String[] str = new String[10000];  
        int cnt = 0, maxlen = 0;  
  
        while (s.hasNextLine()) {  
            str[cnt] = s.nextLine();  
            int temp = str[cnt].length();  
            maxlen = Math.max(temp, maxlen);  
            cnt++;  
        }  
  
        for (int i = 0; i < maxlen + 2; i++) {  
            System.out.print("*");  
        }  
        System.out.println();  
  
        boolean flag = true;
        int ans;
  
        for (int i = 0; i < cnt; i++) {  
            System.out.print("*");  
            int len = maxlen - str[i].length();
            
            if (len % 2 == 1) {  
                flag = !flag;   
            }
            int key = flag?1:0;
            
            ans = (key + len) / 2;
            for (int j = 0; j < ans; j++) {  
                System.out.print(" ");  
            }  
  
            System.out.print(str[i]);  
  
            for (int j = 0; j < len - ans; j++) {  
                System.out.print(" ");  
            }  
  
            System.out.println("*");  
        }  
          
        for (int i = 0; i < maxlen + 2; i++) {  
            System.out.print("*");  
        }  
        System.out.println();  
    }  
}  