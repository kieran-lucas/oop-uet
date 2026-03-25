import java.util.*;
public class Main10 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(4);
		list.add(6);
		list.add(2);
		list.add(3);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}