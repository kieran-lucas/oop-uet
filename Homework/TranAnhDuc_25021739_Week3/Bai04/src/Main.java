public class Main {
	public static class Animal {
		public void makeSound() {
			System.out.println("Animal Sound");
		}

	}
	public static class Dog extends Animal {
		public void makeSound() {
			System.out.println("Woof woof");
		}
	}
	public static class Cat extends Animal {
		public void makeSound() {
			System.out.println("Meows meows");
		}
	}
	public static class Duck extends Animal {

	}
	public static void main(String[] args) {
		//upcasting
		Animal a = new Dog();
		//downcasting
		Cat c;
		if (a instanceof Cat) {
			c = (Cat) a;
			c.makeSound();
		} else {
			System.out.println("Day khong phai la meo");
		}
		
		//goi ham
		
	}
}