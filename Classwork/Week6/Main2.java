interface Food {
	void eat();
}
interface Drink {
	void drink();
}

class Bread implements Food {
	public void eat() {
		System.out.println("Eat bread");
	}
}
class Cake implements Food {
	public void eat() {
		System.out.println("Eat cake");
	}
}
class Coffee implements Drink {
	public void drink() {
		System.out.println("Drink coffee");
	}
}
class Tea implements Drink {
	public void drink() {
		System.out.println("Drink tea");
	}
}

interface RestaurantFactory {
	Food createFood();
	Drink createDrink();
}

class Combo1 implements RestaurantFactory {
	public Food createFood() {
		return new Bread();
	}
	public Drink createDrink() {
		return new Coffee();
	}
}

class Combo2 implements RestaurantFactory {
	public Food createFood() {
		return new Cake();
	}
	public Drink createDrink() {
		return new Tea();
	}
}

public class Main2 {
	public static void main(String[] args) {
		RestaurantFactory combo1 = new Combo1();
		Food f = combo1.createFood();
		Drink d = combo1.createDrink();

		f.eat();
		d.drink();
	}
}