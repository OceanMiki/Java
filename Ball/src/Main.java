import java.util.*;
public class Main {
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[][] = new int[3][n];
		for(int i = 0; i < 3;i++){
			for(int j = 0 ;j < n ;j++){
				arr[i][j] = s.nextInt();
			}
		}
		int count = 0;
		for(int i = 0;i < n;i++){
			for(int j = 0 ;j < n;j++){
				int tmp = 0;
				int flag = 1;
				for(;tmp < 3;tmp++){
					if(arr[tmp][j] <= arr[tmp][i]){
						flag = 0;
						break;
					}
				}
				if(flag == 1){
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		s.close();
	}
}
