public class Dummy {
	static int counter = 0;
	static int count() {
		return counter;
	}
	private String name;

	public Dummy(String name) {
		counter ++;
		this.name = name;

	}
	public static void main(String[] args) {
		System.out.println(Dummy.count());
		Dummy d1 = new Dummy ("First Dummy");
		System.out.println(d1.count());
		Dummy d2 = new Dummy ("Second Dummy");
		System.out.println(d1.count());

	}
}