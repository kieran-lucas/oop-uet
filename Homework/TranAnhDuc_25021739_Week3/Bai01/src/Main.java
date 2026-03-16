public class Main {
	public static class Person {
		String name;
		String dob;
		public Person(String name) {
			System.out.println("1. Person is created");
		}
	}
	public static class Employee extends Person {
		double salary;
		public Employee() {
			//super()
			super("name");
			System.out.println("2. Employee is created");

		}
	}
	public static class Manager extends Employee {
		String department;
		public Manager() {
			//super()
			System.out.println("3. Manager is created");
		}
	}
	public static void main(String[] args) {
		Manager m = new Manager();
	}
}