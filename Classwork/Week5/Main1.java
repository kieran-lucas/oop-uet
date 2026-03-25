class Cat {
	int name;
}
public class Main1 {
	public static void main(String[] args) {
		Cat a = new Cat();
		Class c = a.getClass();
		System.out.println(c);
	}
}