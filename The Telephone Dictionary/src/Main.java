import java.util.*;

public class Main {
	public static String Standard(String s){
		String str = s.replaceAll("-", "");
		
		str = str.replace("A", "2");
		str = str.replace("B", "2");
		str = str.replace("C", "2");
		str = str.replace("D", "3");
		str = str.replace("E", "3");
		str = str.replace("F", "3");
		str = str.replace("G", "4");
		str = str.replace("H", "4");
		str = str.replace("I", "4");
		str = str.replace("J", "5");
		str = str.replace("K", "5");
		str = str.replace("L", "5");
		str = str.replace("M", "6");
		str = str.replace("N", "6");
		str = str.replace("O", "6");
		str = str.replace("P", "7");
		str = str.replace("R", "7");
		str = str.replace("S", "7");
		str = str.replace("T", "8");
		str = str.replace("U", "8");
		str = str.replace("V", "8");
		str = str.replace("W", "9");
		str = str.replace("X", "9");
		str = str.replace("Y", "9");
		
		return str;
	}
	
	public static String plusHyphen(String str){
		return str.substring(0,3) + "-" + str.substring(3,str.length());
	}
	
	public static String[][] sort(String [][]str, int m ){
		for(int i = 0 ; i < m ; i++){
			for(int j = 0;j < m-1; j++){
				int a = Integer.parseInt(str[j][0]);
				int b = Integer.parseInt(str[j+1][0]);
				int c = Integer.parseInt(str[j][1]);
				int d = Integer.parseInt(str[j+1][1]);
				if(a > b){
					String temp = str[j][0];
					str[j][0] = str[j+1][0];
					str[j+1][0] = temp;
					str[j][1] = ""+d;
					str[j+1][1]=""+c;
				}
			}
		}
		return str;
	}
	
	public static void isRepeat(String[] str,int n){
		String ans[][] = new String [n][2];
		int m = 0;
		for(int i = 0 ;i < n ; i++ ){
			int count = 0;
			int key = 1;
			for(int j = 0; j < n ; j++ ){
				if(str[i].equals(str[j])){
					count++;
				}
			}
			if(count > 1){
				if(m == 0){
					ans[0][0] = str[i];
					ans[0][1] = ""+count;
					m++;
				}
				else{
					for(int k = 0; k < m;k++){
						if(ans[k][0].equals(str[i])){
							key = 0;
						}
					}
					if(key == 1){
						ans[m][0] = str[i];
						ans[m][1] = ""+count;
						m++;
					}
				}
			}
		}
		ans = sort(ans,m);
		for(int k = 0 ; k < m; k++ ){
			System.out.println(plusHyphen(ans[k][0])+" "+ans[k][1]);
		}
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		String[] str = new String[n];
		for(int i = 0 ;i < n; i++ ){ 
			str[i] = s.nextLine();
			str[i] = Standard(str[i]);
		}
		isRepeat(str,n);
		
		s.close();
	}
}
