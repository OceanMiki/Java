import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DirListing {
	public static void getFile_1(String Path) {
		File file = new File(Path);
		File[] array = file.listFiles();
		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				System.out.println(array[i].getName());
				System.out.println("The size of the dictory is :");
				if (getFileSizes(array[i]) < 1024) {
					System.out.println(getFileSizes(array[i]) + " " + "Byte");
				} else {
					System.out.println(getFileSizes(array[i]) / 1024 + " " + "KB");
				}
				System.out.println();
			} else if (array[i].isDirectory()) {
				getFile_1(array[i].getPath());
			}
		}
	}

	public static void getFile_2(String Path) {
		File file = new File(Path);
		File[] array = file.listFiles();
		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {

				System.out.println(array[i].getName());
			} else if (array[i].isDirectory()) {
				getFile_2(array[i].getPath());
			}
		}
	}

	public static String getFileTime(String filepath) {

		File f = new File(filepath);
		SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		long time = f.lastModified();
		cal.setTimeInMillis(time);
		return DateFormat.format(cal.getTime());
	}

	private static long getFileSizes(File file) {
		if (file.isFile())
			return file.length();
		final File[] children = file.listFiles();
		long total = 0;
		if (children != null)
			for (final File child : children)
				total += getFileSizes(child);
		return total;
	}

	public static void main(String[] args) {
		System.out.println("******DirListing Program******");
		System.out.println();
		String path = null;
		if (args.length > 3) {
			System.out.println("Invalid arguments");
			System.exit(0);
		}

		if (args.length < 3) {
			path = System.getProperty("user.dir");
		} else if (args.length == 3) {

			path = args[2];
		}

		if (args.length == 2) {

			if (args[0].equals("-R")) {
				if (args[1].equals("-verbose")) {
					System.out.println("The last modified time is :");
					System.out.println(getFileTime(path));
					System.out.println();
					System.out.println("The dictory list contains:");
					System.out.println();
					getFile_1(path);
				} else if (args[1].equals("non-verbose")) {
					System.out.println("The dictory list contains:");
					System.out.println();
					getFile_2(path);
				}

			}
		} else {
			System.out.println("Your current working directory:" + System.getProperty("user.dir"));
		}
	}
}