public class TestExceptions {
	public static void main(String[] args) {
		try {
			for (int i = 0; true; i++) {
				System.out.println("args[" + i + "] is '" + args[i] + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Exception caught: ");
			System.out.print(e);
		} finally {
			System.out.print(" Quiting...");
		}
	}
}
