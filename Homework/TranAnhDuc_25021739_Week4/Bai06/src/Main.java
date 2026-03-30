class ArrayUtils<T> {
	public static <T> void swap(T[] array, int i, int j){
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static <T extends Comparable<T>> void sort(T[] array){
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					swap(array, j, j + 1);
				}
			}
		}

	}
	public static <T> void showResult(T[] array) {
		for(T t : array) {
			System.out.print(t + " ");
		}
	}

}
public class Main extends ArrayUtils{
	public static void main(String[] args) {
		Integer[] arr1 = {5, 1, 3, 2};
		String[] arr2 = {"Java", "C++", "Python"};
		sort(arr1);
		sort(arr2);
		showResult(arr1);
		System.out.println();
		showResult(arr2);


	}
}