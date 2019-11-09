import java.util.*;


public class Main {
	public static void main(String[] args ){
		Scanner s = new Scanner(System.in);
		double x0 = s.nextDouble();
		double y0 = s.nextDouble();
		double x1 = s.nextDouble();
		double y1 = s.nextDouble();
		double x2 = s.nextDouble();
		double y2 = s.nextDouble();
		
		if((x1-x0)*(y2-y0)-(x2-x0)*(y1-y0) > 0){
			System.out.printf("(%.1f, %.1f) is on the left side of the line from (%.1f, %.1f) to (%.1f, %.1f)",x2,y2,x0,y0,x1,y1);
            System.out.println();
		}
		else if((x1-x0)*(y2-y0)-(x2-x0)*(y1-y0) == 0){
			System.out.printf("(%.1f, %.1f) is on the same line from (%.1f, %.1f) to (%.1f, %.1f)",x2,y2,x0,y0,x1,y1);
			System.out.println();
		}
		else if((x1-x0)*(y2-y0)-(x2-x0)*(y1-y0) < 0){
			System.out.printf("(%.1f, %.1f) is on the right side of the line from (%.1f, %.1f) to (%.1f, %.1f)",x2,y2,x0,y0,x1,y1);
			System.out.println();
		}
		
	}

}
