class Pair<K, V> {
	private K key;
	private V value;
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public void setValue(V value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return key + " - " + value;
	}
}
public class Main {
	public static void main(String[] args) {
		Pair<String, Integer> obj1 = new Pair<String, Integer>("Tuoi", 20);
		Pair<String, String> obj2 = new Pair<String, String>("Ma SV", "SV001");
		Pair<Integer, Double> obj3 = new Pair<Integer, Double>(105, 21.5);
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());

	}
}