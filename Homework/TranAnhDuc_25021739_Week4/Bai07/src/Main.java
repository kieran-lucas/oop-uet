import java.util.*;
class Student {
	private String id;
	private String name;
	private double gpa;
	public Student(String id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getGPA() {
		return gpa;
	}
	public void show() {
		System.out.println(id + " " + name + " " + gpa);
	}

}
interface Operation<T> {
	T execute(T a, T b);
}
public class Main {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String id = sc.next();
			String name = sc. next();
			double gpa = sc.nextDouble();
			sc.nextLine();
			students.add(new Student(id, name, gpa));
		}
		students.removeIf(student -> student.getGPA() < 5.0);
		System.out.println();
		System.out.println("After removing GPA < 5.0: ");
		for (Student s : students) {
			s.show();
		}
		students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
		System.out.println();
		System.out.println("After sorting by name: ");
		for (Student s : students) {
			s.show();
		}
		Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> a / b;

        System.out.println("\nDemo Operation:");
        System.out.println("Add: " + add.execute(10.0, 5.0));
        System.out.println("Sub: " + sub.execute(10.0, 5.0));
        System.out.println("Mul: " + mul.execute(10.0, 5.0));
        System.out.println("Div: " + div.execute(10.0, 5.0));

	}
}
