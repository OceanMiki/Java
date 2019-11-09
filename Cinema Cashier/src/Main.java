import java.util.Scanner;

public class Main {
	public static int abs(int num){
		return (num > 0)?num:-num;
	}
	public static void main(String[] args){
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int mp[][] = new int[1002][1002];
		for (int l = 1;l<=n;l++)
		{
			int x = s.nextInt();
	        int px = (k+1)/2;
			int py = (k+1)/2;
	        int ans1 = 0,ans2=0,ans3=0,ans4=2147483647;
			for (int i = 1;i<=k;i++)
				for(int j = 1;j<=k-x+1;j++)
				{
					int sum = 0,flag=1;
					for (int t = j;t<j+x;t++)
					{
						if (mp[i][t] != 0)
						{
							flag=0;
							break;
						}
						sum+=abs(t-py)+abs(i-px);
					}
					if (flag == 1 && sum<ans4){
						ans4 = sum;
						ans1=i;
						ans2=j;
						ans3=j+x-1;
						}
				}
			if (ans4 == 2147483647)
				System.out.printf("-1\n");
			else
			{
				for (int i = ans2;i<=ans3;i++)
					mp[ans1][i]=1;
				System.out.printf("%d %d %d\n",ans1,ans2,ans3);
			}
		}
	}
}
