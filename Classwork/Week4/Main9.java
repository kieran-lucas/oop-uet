interface CanFlight {
	void flight();
}
interface CanSwim {
	void swim();
}
interface CanFly {
	void fly();
}
class ActionCharacter {
	public void flight() {

	}
}
class Hero extends ActionCharacter implements CanFlight, CanSwim, CanFly {
	public void swim() {

	}
	public void fly() {

	}

}
public class Adventure {
	public static void t(CanFlight x ) {
		x.flight();
	}
	public static void u(CanSwim cx) {
		x.swim();
	}
	public void v(CanFly x ) {
		x.fly()
	}
	public static void w(ActionCharacter x) {
		x.flight();
	}
	public static void main(String[] args) {
		Hero h = new Hero();
		t(h);
		u(h);
		v(h);
		w(h);
		
	}
}