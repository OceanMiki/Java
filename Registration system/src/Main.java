import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		HashMap<String,Integer>mp = new HashMap<String,Integer>();
		mp.clear();
		s.nextLine();
		while(n-- > 0){
			String str = s.nextLine();
			if(mp.containsKey(str)){
				Integer temp = mp.get(str)+1;
				mp.put(str, temp);
				System.out.println("Str"+temp);
			}
			else{
				mp.put(str, 0);
				System.out.println("OK");
			}
		}
	}

}
