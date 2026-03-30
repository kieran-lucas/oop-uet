import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap duong dan nguon: ");
		String sourcePath = sc.nextLine();
		System.out.println("Nhap duong dan dich: ");
		String desPath = sc.nextLine();

	
		BufferedReader br = null;
		PrintWriter pw = null;
		int lineCount = 0;

		try {
			br = new BufferedReader(new FileReader(sourcePath));
			pw = new PrintWriter(new FileWriter(desPath));
			String line;
			while((line = br.readLine()) != null) {
				pw.println(line);
				lineCount++;
			}
			System.out.println("Sao chep thanh cong! So dong da sao chep la: " + lineCount);

		} catch (FileNotFoundException e) {
			if (br == null) {
				System.out.println("Source file not found");
			} else {
				System.out.println("Cannot create destination file");
			}
		} catch (IOException e ) {
			System.out.println("I/O error.");
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (pw != null) {
					pw.close();
				}
			} catch (IOException e) {
				System.out.println("Error closing file");
			}
		}
		sc.close();
	}
}