abstract class Shape implements Action {
	protected int x, y;
	public Shape() {

	}
	public Shape(int _x, int _y) {

	}
	public void moveTo(int x1, int y1) {
		erase();
		x = x1;
		y = y1;
		draw();

	}
}