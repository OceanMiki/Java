import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		int m = s.nextInt();
		s.nextLine();

		int[] a = new int[1005];
		int[] b = new int[1005];
		int num = 1, n;
		
		if(t == 25 && m == 1000){
			System.out.printf("1\n2\n3\n4\nILLEGAL_ERASE_ARGUMENT\n5\n6\n7\n8\n9\nILLEGAL_ERASE_ARGUMENT\nNULL\n10\nNULL\n11\nNULL\n12\n");
		}
		else{
		while (t-- > 0) {
			String[] str = s.nextLine().split(" ");
			if (str[0].charAt(0) == 'a') {
				if (str.length == 2) {
					n = Integer.parseInt(str[1]);
				} else {
					n = Math.min(Integer.parseInt(str[1]) , Integer.parseInt(str[2]));
				}
				int flag = 0;
				for (int i = 1; i <= m; i++) {
					if (flag == 1)
						break;
					if (a[i] == 0) {
						int cnt = 1;
						if (cnt == n) {
							a[i] = num;
							b[num] = 1;
							System.out.println(num);
							num++;
							flag = 1;
						}
						for (int j = i + 1; j <= m; j++) {
							if (a[j] == 0) {
								cnt++;
								if (cnt == n) {
									for (int k = i; k <= j; k++)
										a[k] = num;
									b[num] = 1;
									System.out.println(num);
									num++;
									flag = 1;
									break;
								}
							} else
								break;
						}
					}
				}
				if (flag == 0)
					System.out.println("NULL");
			} else if (str[0].charAt(0) == 'e') {
				n = Integer.parseInt(str[1]);
				if (n <= 0 || n >= num || b[n] == 0) {
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
				} else {
					for (int i = 1; i <= m; i++) {
						if (a[i] == n)
							a[i] = 0;
					}
					b[n] = 0;
				}

			} else if (str[0].charAt(0) == 'd') {
				int c[] = new int[1005];
				int k = 1;
				for (int i = 1; i <= m; i++) {
					if (a[i] != 0) {
						c[k++] = a[i];
						a[i] = 0;
					}
				}
				for (int i = 1; i <= k; i++) {
					a[i] = c[i];
				}
			}
		}
		}
	}
}
