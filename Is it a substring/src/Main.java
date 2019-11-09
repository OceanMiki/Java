
/* PRESET CODE BEGIN - NEVER TOUCH CODE BELOW */

import java.util.*;

class IsSubString {
	public boolean isSubString(String sub, String mother) {
		int len1 = sub.length();
		int len2 = mother.length();
		int flag = 0;
		for (int i = 0; i < len2; i++) {
			if (mother.charAt(i) == sub.charAt(0)) {
				flag = 1;
				for (int j = 1, k = i + 1; j < len1; j++, k++) {
					if (k < len2) {
						if (mother.charAt(k) != sub.charAt(j)) {
							flag = 0;
							break;
						}
					}
					if (k >= len2) {
						flag = 0;
					}
				}
				if(flag == 1){
					break;
				}
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}
}

class Main {
	public static void main(String[] args) {
		IsSubString iss = new IsSubString();
		Scanner scanner = new Scanner(System.in);
		// Get test cases.
		String str = scanner.nextLine();
		int t = Integer.parseInt(str);
		while (t-- > 0) {
			String sub = scanner.nextLine();
			String mother = scanner.nextLine();
			System.out.println(iss.isSubString(sub, mother));
		}
	}
}

/* PRESET CODE END - NEVER TOUCH CODE ABOVE */
