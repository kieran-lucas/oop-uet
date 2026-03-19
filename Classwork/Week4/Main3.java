abstract class Shape {
	protected int x,y;
	abstract public void erase();
	abstract public void draw();
	public void moveto (int x1, int y1) {
		
	}
}
class Circle extends Shape {
	int r;
	public Circle(int _x, int _y, int _r) {
		super(_x, _y);
		r = _r;
		draw();
	}
	public void erase() {
		System.out.println("Erase at (" + x + "," + y + ")");

	}
	public void draw() {
		System.out.println("Draw at (" + x + "," + y + ")");
		
	}
}