import java.io.*;
public class Main {
	public static void main(String[] args) {
		File file = new File("input.txt");
		File file_2 = new File("output.txt");
		int count = 1;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			PrintWriter out = new PrintWriter(new FileWriter(file_2));
			String s;
			s = in.readLine();
			while (s != null) {
				out.println(count +" "+ s);
				count++;
				s = in.readLine();
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e1) {
			System.err.println("File not found:" + file);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

}
