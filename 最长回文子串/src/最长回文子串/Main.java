package 最长回文子串;

public class Main {
	public static void main(String[] args)
	{
		String s = "ababd";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            int len1 = Center(s, i, i);
            int len2 = Center(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) 
            {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        System.out.println("" + s.substring(start, end + 1));
	}
	 static int Center(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
}
