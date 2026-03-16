public class Main1 {
	public static class Person {
		String name;
		String birthday;
		public void setName(String n) {
			name = n;
		}
		public void setBirthday(String d) {
			birthday = d;
		}
		public String getName() {
			return name;
		}
		public String getDetail() {
			return name + " - " + birthday;
		}

	}
	public static class Employee extends Person {
		double salary;
		public boolean setSalary (double sal) {
			salary = sal;
			return true;
		}
	}
	public static void main(String[] args) {
		Employee e = new Employee ();
		e.setBirthday("2/2/2002");
		e.setName("Join");
		e.setSalary(3.66);
		System.out.print(e.getDetail());
	}
}