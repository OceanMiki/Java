import java.util.*;

public class Main {
	public static int next[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	public static int n, m;
	public static char c;
	public static StringBuffer map[] = new StringBuffer[101];
	public static int vis[] = new int[26];

	public static void dfs(int x, int y) {
		int mx, my;
		for (int i = 0; i < 4; i++) {
			mx = x + next[i][0];
			my = y + next[i][1];
			if (mx < 0 || my < 0 || mx >= n || my >= m) {
				continue;
			}
			if (map[mx].charAt(my) != '.') {
				if (c == map[mx].charAt(my)) {
					map[mx].setCharAt(my, '.');
					dfs(mx, my);
					
				} else {
					vis[map[mx].charAt(my) - 'A'] = 1;
					map[mx].setCharAt(my, '.');
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ans = 0;

		n = s.nextInt();
		m = s.nextInt();
		String ch = s.nextLine();
		c = ch.charAt(1);
		
		for (int i = 0; i < n; ++i) {
			String str = s.nextLine();
			map[i] = new StringBuffer(str);
		}
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < m; ++j) {
				if (c == (map[i].charAt(j))) {
					dfs(i, j);
					break;
				}
			}
		for (int i = 0; i < 26; ++i)
			if (vis[i] != 0) {
				ans++;
			}
		System.out.println(ans);

		s.close();
	}
}
