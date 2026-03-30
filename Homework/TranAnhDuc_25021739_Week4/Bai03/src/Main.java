import java.util.*;
interface IWorkable {
	void work();
}
abstract class Employee implements IWorkable {
	private String id;
	private String name;
	private double baseSalary;
	abstract double calculatePay();
	public Employee(String id, String name, double baseSalary) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	public String getName() {
		return this.name;
	}
	public double getBaseSalary() {
		return baseSalary;
	}

}
class OfficeWorker extends Employee {
	public OfficeWorker(String id, String name, double baseSalary) {
		super(id, name, baseSalary);
	}
	public double calculatePay() {
		return getBaseSalary();
	}
	public void work() {
		System.out.println("Soan thao van ban");

	}

}
class Technician extends Employee {
	private int overtimeHours;
	public Technician(String id, String name, double baseSalary, int overtimeHours) {
		super(id, name, baseSalary);
		this.overtimeHours = overtimeHours;
	}
	public double calculatePay() {
		return getBaseSalary() + overtimeHours *20000;

	}
	public void work() {
		System.out.println("Lap dat thiet bi");
	}

}
public class Main {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String type = sc.next();
			String id = sc.next();
			String name = sc.next();
			double baseSalary = sc.nextDouble();
			

			if (type.equals("O")) {
				employees.add(new OfficeWorker(id, name, baseSalary));

			} else if (type.equals("T")) {
				int overtimeHours = sc.nextInt();
				sc.nextLine();
				employees.add(new Technician(id, name, baseSalary, overtimeHours));

			}
			
		}
		for (Employee e : employees) {
			String name = e.getName();
			double totalSalary = e.calculatePay();
			System.out.println(name + " - " + "Pay: " + totalSalary);
			e.work();

		}

	}
}
