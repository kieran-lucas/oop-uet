import java.io.Serializable;
import java.io.*;
import java.util.*;

class Student implements Serializable {
	private String id;
	private String name;
	private double gpa;

	public Student(String id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return id + " - " + name + " - " + gpa;
	}
}

public class Main {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Nhap id (END de dung): ");
			String id = sc.nextLine();
			if (id.equals("END")) {
				break;
			}

			System.out.print("Nhap ten: ");
			String name = sc.nextLine();

			System.out.print("Nhap gpa: ");
			double gpa = Double.parseDouble(sc.nextLine());

			list.add(new Student(id, name, gpa));
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
			for (Student s : list) {
				oos.writeObject(s);
			}
			System.out.println("Ghi file thanh cong!");
		} catch (FileNotFoundException e) {
			System.out.println("Khong tao duoc file");
		} catch (IOException e) {
			System.out.println("Loi ghi file");
		}

		try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("students.dat"))) {

            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s);
            }

        } catch (EOFException e) {
            System.out.println("Da doc het file");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay class");
        } catch (IOException e) {
            System.out.println("Loi doc file");
        }

        sc.close();
    }
}
