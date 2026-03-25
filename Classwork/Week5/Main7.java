public class Main7 {
	public static void main(String[] args) {
		int a[][];
		a = new int[10][20];
		a[2][3] = 10;
		for (int i = 0; i < a[0].length; i++) {
			a[0][i] = i;
			for (int w : a[0]) {
				System.out.print(w + " ");

			}
		}
		int b[][] = {{1, 2}, {3, 4}};
		int c[][] = new int[2][];
		c[0] = new int[5];
		c[1] = new int[10];
	}
}