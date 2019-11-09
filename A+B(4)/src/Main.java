import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    
        Scanner s=new Scanner(System.in);        
        while( true )
        {
            long a=s.nextLong(),b=s.nextLong();
            if(a == 0 && b == 0)
                break;
            System.out.println(a+b);
        }
    }    
}
