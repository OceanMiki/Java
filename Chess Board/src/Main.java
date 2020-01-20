import java.util.Scanner;
public class Main {
	public static void main (String []args){
		Scanner s = new Scanner (System.in);
		String str[] = new String[8];
		String temp = "BBBBBBBB";
		int count[] = new int[8];
		int ans = 0;
		for(int i=0;i<8;i++)
		{
			str[i] = s.nextLine();
			for(int j=0;j < 8 ;j++)  
			{
				if(str[i].charAt(j)=='B')
					count[j]++;
			}
			if(str[i].equals(temp))
			{
				ans++;
				for(int j=0;j<8;j++)
					count[j]--;
			}
		}
		for(int j=0;j<8;j++)
		{
			if(count[j]!=0)
				ans++;
		}
		System.out.println(ans);
	}
}
