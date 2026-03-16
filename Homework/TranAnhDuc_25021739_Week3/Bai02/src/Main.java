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
		Animal[] zoo = new Animal[4];
		zoo[0] = new Dog();
		zoo[1] = new Cat();
		zoo[2] = new Duck();
		zoo[3] = new Dog();
		for (int i = 0; i < 4; i++) {
			zoo[i].makeSound();
		}
	}
}