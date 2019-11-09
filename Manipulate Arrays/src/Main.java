
public class Main {
	 public static void printArray(int[] array) {
		 System.out.print('<');
		 for ( int i = 0; i < array.length; i++ ) { 
		 // print an element
		 System.out.print(array[i]); 
		 // print a comma delimiter if not the last element 
		 if ( (i + 1) < array.length ) { 
		 System.out.print(", "); 
		 }
		 }
		 System.out.println('>');
		}
	public static void main(String[] args){
		int array1[] = {2,3,5,7,11,13,17,19};
		printArray(array1);
		int[] array2 = array1;
		array2[0] = 0;
		array2[2] = 2;
		array2[4] = 4;
		array2[6] = 6;
		printArray(array1);
		int[][] matrix = {{},{0},{0,2},{0,3,6},{0,4,8,12}};
		for(int i = 0;i < 5; i++ ){
			System.out.printf("matrix[%d] is ",i);
			printArray(matrix[i]);
		}
	}
}
