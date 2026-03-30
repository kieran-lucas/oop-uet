import java.io.*;
import java.util.*;

public class ReadNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DataInputStream dis = null;

		try {
			System.out.print("Nhap ten file: ");
			String fileName = sc.nextLine();

			dis = new DataInputStream(new FileInputStream(fileName));

			System.out.print("Cac so trong file: \n");

			while (true) {
				int x = dis.readInt();
				System.out.println(x);
			}
		} catch (EOFException e) {
			System.out.println("Da doc het file");
		} catch (IOException e) {
			System.out.println("Loi doc file");
		} finally {
			try {
				if (dis != null) {
					dis.close();
				} 
			} catch (IOException e) {
				System.out.println("Loi dong file!");
			}
			sc.close();
		}
	}
}