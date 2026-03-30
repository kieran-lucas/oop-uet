import java.util.*;
class WordCounter {
	public static HashMap<String, Integer> analyze(String text) {
		text = text.toLowerCase();
		text = text.replaceAll("[^a-z0-9\\s]", " ");
		String[] words = text.split("\\s+");
		HashMap<String, Integer> freq = new HashMap<String, Integer>();
		for (String word : words) {
			// if (freq.containsKey(word)) {
			// 	freq.put(word, freq.get(word) + 1);
			// } else {
			// 	freq.put(word, 1);
			// }
			freq.put(word, freq.getOrDefault(word, 0) + 1);
		}
		return freq;

	}
	public static void displayResult(String text) {
		HashMap<String, Integer> freq = analyze(text);
		System.out.println("\nDanh sach cac tu va so luong: ");
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
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
	}
}
public class Main extends WordCounter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		displayResult(text);
	}
}