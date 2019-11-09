import java.util.*;  
  
public class Main { 
	public static final int   MIN_VALUE = 0x80000000;
    public static void main(String[] args) {  
        HashMap<String, Integer> mp1 = new HashMap<String, Integer>();  
        HashMap<String, Integer> mp2 = new HashMap<String, Integer>();  
        Scanner cin = new Scanner(System.in);  
        int n = cin.nextInt();  
        cin.nextLine();  
        String s[] = new String[1010];  
        int a[] = new int[1010];  

        for (int i = 0; i < n; i++) {  
            s[i] = cin.next();  
            a[i] = cin.nextInt(); 
            Integer temp1 = 0;
            if (mp1.containsKey(s[i])) {  
                temp1 = a[i] + mp1.get(s[i]);  
                mp1.put(s[i], temp1);  
            } else {  
                mp1.put(s[i], a[i]);  
            }  
        }  
        int maxn = MIN_VALUE;
        for (int i = 0; i < n; i++) {  
            maxn = Math.max(maxn, mp1.get(s[i]));
        }  
        for (int i = 0; i < n; i++) { 
        	Integer temp2 = 0;
            if (mp2.containsKey(s[i])) {  
                temp2 = a[i] + mp2.get(s[i]);  
                mp2.put(s[i], temp2);  
            } else {  
                mp2.put(s[i], a[i]);  
            }  
            if ((mp2.get(s[i]) == maxn) && mp1.get(s[i]) >=maxn )// 在最终分数是最大的人中，选首先达到最大分数的人  
            {  
                System.out.println(s[i]);  
                break;  
            }  
        }  
        cin.close();
    }  
}