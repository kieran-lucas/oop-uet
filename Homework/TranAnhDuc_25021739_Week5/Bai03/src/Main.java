import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9\\s]", " ");
		String[] words = s.split("\\s+");
		HashMap<String, Integer> freq = new HashMap<String, Integer>();
		for (String word : words) {
			freq.put(word, freq.getOrDefault(word, 0) + 1);
		}
		String maxKey = null;
		int maxValue = 0;
		boolean check = false;
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			int v = entry.getValue();
			if (v > maxValue) {
				maxValue = v;
				maxKey = entry.getKey();
				check = true;
			} else if (v == maxValue) {
				check = false;
			}

		}
		if (!check) {
			System.out.println("\nKhong co tu nao xuat hien nhieu nhat");

		} else {
			System.out.println("\nTu xuat hien nhieu nhat la \"" + maxKey + "\" voi " + maxValue + " lan");
		}

		System.out.println("Cac tu chi xuat hien dung mot lan: ");
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey()+ " -> " + entry.getValue());
			}
			
		}

	}
}