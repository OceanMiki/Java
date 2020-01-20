import java.util.Scanner;
public class Main {
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		s.nextLine();
		String letter[] = new String[n];
		for(int i = 0;i < n;i++){
			letter[i] = s.nextLine();
		}
		int maxx = 0, maxy = 0, minx = 999, miny = 999;
		for(int i = 0;i < n;i++){
			for(int j = 0; j < m;j++){
				if(letter[i].charAt(j) == '*'){
					if(i > maxx){
						maxx = i;
					}
					if(i < minx){
						minx = i;
					}
					if(j > maxy){
						maxy = j;
					}
					if(j < miny){
						miny = j;
					}
				}
			}
		}
		for(int i = minx;i <= maxx;i++){
			System.out.println(letter[i].substring(miny, maxy+1));
		}
		s.close();
	}
}