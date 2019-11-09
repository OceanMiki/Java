import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		int gift[][] = new int[n][2];
		String name[] = new String[n];
		for (int i = 0; i < n; i++) {
			name[i] = s.next();
			hash.put(name[i], i);
		}
		for (int i = 0; i < n; i++) {
			String na = s.next();
			int value = hash.get(na);
			double money = s.nextInt();
			int num = s.nextInt();
			if (num != 0) {
				int avg = (int) Math.floor(money / num);
				gift[value][0] = avg * num;
				for (int j = 0; j < num; j++) {
					String nam = s.next();
					int val = hash.get(nam);
					gift[val][1] += avg;
				}
			}
		}
		for (int k = 0; k < n; k++) {
			System.out.print(name[k] + " ");
			System.out.println(gift[k][1] - gift[k][0]);
		}
	}
}
