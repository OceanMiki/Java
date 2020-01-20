import java.util.*;
public class Main {
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[] = new int[n];
		int num[] = new int[n];
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0;i < n;i++){
			arr[i] = s.nextInt();
		}
		s.nextLine();
		Arrays.sort(arr);
		
		int cnt = 0, max = 0, min = 0;
		
		for(int j = 0;j < m;j++){
			String str = s.nextLine();
			if (map.containsKey(str)){
				num[map.get(str)]+=1;
			}
			else{
				num[cnt] = 1;
				map.put(str, cnt);
				cnt++;
			}
		}
		Arrays.sort(num);
		for(int k = 0;k < num.length;k++){
			min+=num[num.length-k-1]*arr[k];
			max+=num[num.length-k-1]*arr[arr.length-k-1];
		}
		System.out.println(min+" "+max);
	}
}
