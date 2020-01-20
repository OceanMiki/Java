import java.util.Scanner;

public class Main {
	private static int dx[] = { -1, 0, 1, 0, -1, -1, 1, 1 };
	private static int dy[] = { 0, -1, 0, 1, -1, 1, -1, 1 };
	private static int n, m, t;
	private static char[][] str = new char[260][260];

	private static void dfs(int x, int y) {
		str[x][y] = '2';
		t += 1;
		for (int j = 0; j < 8; j++) {
			int tx = x + dx[j], ty = y + dy[j];
			if (tx >= 0 && tx < n && ty >= 0 && ty < m && str[tx][ty] == '1')
				dfs(tx, ty);
		}
	}

	private static int check1(int x, int y, int l) {
		l++;
		if (x + l - 1 >= n || y + l - 1 >= m)
			return 0;
		for (int i = 0; i < l; i++) {
			if (str[x][y + i] != '2')
				return 0;
			if (str[x + i][y] != '2')
				return 0;
			if (str[x + l - 1][y + i] != '2')
				return 0;
			if (str[x + i][y + l - 1] != '2')
				return 0;
		}
		return 1;
	}

	private static int check2(int x, int y, int l) {
		l++;
		if (x + 2 * (l - 1) >= n || y + l - 1 >= m || y - l + 1 < 0)
			return 0;
		for (int i = 0; i < l; i++) {
			if (str[x + i][y + i] != '2')
				return 0;
			if (str[x + i][y - i] != '2')
				return 0;
			if (str[x + l - 1 + i][y + l - 1 - i] != '2')
				return 0;
			if (str[x + l - 1 + i][y - l + 1 + i] != '2')
				return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while (T-- > 0) {
			int ans = 0;
			n = s.nextInt();
			m = s.nextInt();
			for (int i = 0; i < n; i++)
				str[i] = s.next().toCharArray();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (str[i][j] == '1') {
						t = 0;
						dfs(i, j);
						if (t % 4 == 0) {
						    ans += check1(i, j, t / 4);
							ans += check2(i, j, t / 4);
						}
					}
				}
			}
			System.out.println(ans);
		}
		s.close();
	}
}