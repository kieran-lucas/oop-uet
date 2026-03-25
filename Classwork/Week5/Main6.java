import java.util.Arrays;
public class Main6 {
	public static void main(String[] args) {
		
		int[] a = {0, 1, 1, 2, 3, 5, 8};
		int[] b = myCopy(a);
		System.out.println(Arrays.toString(b));
	}
	public static int[] myCopy(int[] a) {
		int b[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		return b;
	}
}
