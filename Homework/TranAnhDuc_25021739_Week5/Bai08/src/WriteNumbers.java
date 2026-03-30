import java.io.*;
import java.util.*;

public class WriteNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DataOutputStream dos = null;
		try {
			System.out.print("Nhap ten file: ");
			String fileName = sc.nextLine();

			System.out.print("Nhap so luong n: ");
			int n = sc.nextInt();

			dos = new DataOutputStream(new FileOutputStream(fileName));

			for (int i = 0; i < n; i++) {
				System.out.print("Nhap so thu " + (i + 1) + ": ");
				int x = sc.nextInt();
				dos.writeInt(x);
			}
			System.out.println("Ghi file thanh cong!" );

		} catch (IOException e) {
			System.out.println("Loi ghi file!");
		} finally {
			try {
				if (dos != null) dos.close();
			} catch (IOException e) {
				System.out.print("Loi dong file!");
			}
			sc.close();
		}
	}
}