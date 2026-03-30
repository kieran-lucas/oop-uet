abstract class Shape {
	protected int x, y;
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public abstract void draw();
	public abstract void erase(); 
	void moveTo(int newX, int newY) {
		erase();
		this.x = newX;
		this.y = newY;
		draw();
	}
}
class Circle extends Shape {
	public Circle(int x, int y) {
		super(x, y);
	}
	public void draw() {
		System.out.println("Ve hinh tron tai " + "(" + x + ", " + y + ")");
	}
	public void erase() {
		System.out.println("Xoa hinh tron tai " + "(" + x + ", " + y + ")");
	}
}
class Square extends Shape {
	public Square(int x, int y) {
		super(x, y);
	}
	public void draw() {
		System.out.println("Ve hinh vuong tai " + "(" + x + ", " + y + ")");
	}
	public void erase() {
		System.out.println("Xoa hinh vuong tai " + "(" + x + ", " + "y" + ")");
	}

}
public class Main {
	public static void main(String[] args) {
		Circle circle = new Circle(10, 10);
		circle.moveTo(20, 20);


	}
}