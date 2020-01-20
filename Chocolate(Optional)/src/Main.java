import java.util.Scanner;
public class Main {
	public static void main (String []args){
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		int a[] = new int[10010];
		for(int i = 1; i <= n; i++){
			a[i] = s.nextInt();
		}
		int l = 0, r = 0, cnt1 = 0, cnt2 = 0;
		for (int i = 1, j = n; i <= j; ) {
			if (l <= r) {
				l = l + a[i];
				cnt1++;
				i++;
			}
			else {
				r = r + a[j];
				cnt2++;
				j--;
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}
}
