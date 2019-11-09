import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
        int max=s.nextInt();
        double item=0;
        double sum=0;
        int flag=-1;
         
        int n=0;
        for(n=0;n<=max/2;n++)
        {
            flag*=-1;
            item=flag*1.0/(2*n+1);
            sum += item;
        }
        
        String result = String .format("%.6f",sum*4.0);
        
        System.out.println(Double.parseDouble(result));
    }

}
