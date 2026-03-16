public class Main {
	public static class Person {
		private String name;
		private Date bithday;
		public String getName() {
			return name;
		}
	}
	public static class Employee {
		private Person me;
		private double salary;
		public String getName() {
			return me.getName();
		}
	}
	public static class Manager{
		private Employee me;
		private Employee assistant;
		public void setAssistant(Employee e) {
			return assistant = e;
		}
	}
	public static void main(String[] args) {
		Manager junior = new Manager();
		Manager senior = new Manager();
		senior.setAssistant(junior);	
	}
}
