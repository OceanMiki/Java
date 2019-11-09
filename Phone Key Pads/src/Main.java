import java.util.Scanner;

public class Main {
	public static void run(String str){
		str = str.replace(" ", "0");
		boolean hasSymble = !str.matches("^[\\da-zA-Z]*$");
		if(hasSymble){
			System.out.println("Invalid input");
		}
		else{
		String s = str.toUpperCase();
		
		s= s.replace("A", "2");
		s= s.replace("B", "2");
		s= s.replace("C", "2");
		s= s.replace("D", "3");
		s= s.replace("E", "3");
		s= s.replace("F", "3");
		s= s.replace("G", "4");
		s= s.replace("H", "4");
		s= s.replace("I", "4");
		s= s.replace("J", "5");
		s= s.replace("K", "5");
		s= s.replace("L", "5");
		s= s.replace("M", "6");
		s= s.replace("N", "6");
		s= s.replace("O", "6");
		s= s.replace("P", "7");
		s= s.replace("Q", "7");
		s= s.replace("R", "7");
		s= s.replace("S", "7");
		s= s.replace("T", "8");
		s= s.replace("U", "8");
		s= s.replace("V", "8");
		s= s.replace("X", "9");
		s= s.replace("Y", "9");
		s= s.replace("Z", "9");
		s= s.replace("W", "9");
		System.out.println(s);
		}
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String str = s.nextLine();
			run(str);
		}
		s.close();
	}
}