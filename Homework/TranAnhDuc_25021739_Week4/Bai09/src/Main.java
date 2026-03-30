import java.util.*;
abstract class Product {
	private String id;
	private String name;
	public Product(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getID() {
		return id;
	}
	public String getName(){
		return name;
	}
	public abstract void getInfor();
}
class Food extends Product {
	private String expiryDate;
	public Food(String id, String name, String expiryDate) {
		super(id, name);
		this.expiryDate = expiryDate;
	}
	public void getInfor() {
		System.out.println(getName() + " - HSD: " + expiryDate);
	}

}
class Electronic extends Product {
	private int warrantyTime;
	public Electronic(String id, String name, int warrantyTime) {
		super(id, name);
		this.warrantyTime = warrantyTime;
	}
	public void getInfor() {
		System.out.println(getName() + " - HBH: " + warrantyTime + " thang");
	}
}
class WareHouse<T extends Product> {
	private List<T> food = new ArrayList<T>();
	private List<T> electronic = new ArrayList<T>();
	public void addItem(T item) {
		if (item instanceof Food) {
			food.add(item);
		} else if (item instanceof Electronic) {
			electronic.add(item);
		}
		
	}
	public void removeItem(String id) {
		food.removeIf(item -> item.getID().equals(id));
		electronic.removeIf(item -> item.getID().equals(id));
	}
	public void printInventory() {
		System.out.println("Kho thuc pham: ");
		for (T item : food) {
			item.getInfor();
		}
		System.out.println("Kho dien tu: ");
		for (T item : electronic) {
			item.getInfor();
		}
	}
}
public class Main {
	public static void main(String[] args) {
		WareHouse<Product> p1 = new WareHouse<Product>();
		p1.addItem(new Food("001", "Bread", "9/9/2026"));
		p1.addItem(new Electronic("003", "TV", 8));
		p1.addItem(new Food("002", "Apple", "3/8/2026"));
		p1.addItem(new Electronic("004", "Phone", 32));
		p1.printInventory();
		p1.removeItem("003");
		System.out.println();
		System.out.println("Sau khi xoa:");
		p1.printInventory();
	}
}