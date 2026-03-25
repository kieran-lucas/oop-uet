import java.util.Arrays;
public class Main8 {
	public static void main(String[] args) {
		int[] arr1 = {0, 1, 2, 3, 4, 5};
		int[] arr2 = {5, 10, 20, 30, 40, 50};
		System.arraycopy(arr1, 0, arr2, 1, 2);
		System.out.println(Arrays.toString(arr2));

	}
}