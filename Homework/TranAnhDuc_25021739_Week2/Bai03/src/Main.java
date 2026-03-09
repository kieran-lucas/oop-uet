public class Main {
	public static class NumberWrapper {
		private int value;
		public void setValue(int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
		
	}
	public static void swap(NumberWrapper a, NumberWrapper b) {
		int temp = a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);

	}
	public static void main(String[] args) {
		NumberWrapper a = new NumberWrapper();
		NumberWrapper b = new NumberWrapper();
		a.setValue(5);
		b.setValue(10);
		System.out.println(a.getValue() + " " + b.getValue());
		swap(a, b);
		System.out.println(a.getValue() + " " + b.getValue());

	}
}