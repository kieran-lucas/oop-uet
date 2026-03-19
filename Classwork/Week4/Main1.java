abstract class Shape {
	protected int x, y;
	Shape(int _x, int _y) {
		x = _x;
		y = _y;
	}
}
class Circle extends Shape {

}
public class Main1 {
	public static void main(String[] args) {
		Shape s = new Shape(10, 10);
		Shape s1 = new Circle();
	}
}
