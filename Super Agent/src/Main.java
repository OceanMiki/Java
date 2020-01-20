import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str[] = new String[3];
		int flag = 0;
		for (int i = 0; i < 3; i++) {
			str[i] = s.nextLine();
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (str[i].charAt(j) != (str[2 - i].charAt(2 - j))) {
					System.out.println("NO");
					flag = 1;
					break;
				}
			}
			if(flag==1){
				break;
			}
		}
		if (flag == 0)
			System.out.println("YES");
		s.close();
	}
}
