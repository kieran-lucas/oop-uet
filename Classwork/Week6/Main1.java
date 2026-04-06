public class Main1 {
	public static void main(String[] args) {
		Type obj1 = new TypeA();
		obj1.action();

	}
}
interface Type {
	void action();
}
class TypeA implements Type {
	public void action() {
		System.out.println("Action from A");
	}
}
class TypeB implements Type {
	public void action() {
		System.out.println("Action from B");
	}
}
abstract class Factory {
	public abstract Type createType();
	public void plan() {
		Type obj = createType();
		obj.action();

	}
}
class FactoryA extends Factory {
	public Type createType() {
		return new TypeA();
	}

}
class FactoryB extends Factory {
	public Type createType() {
		return new TypeB();
	}
}