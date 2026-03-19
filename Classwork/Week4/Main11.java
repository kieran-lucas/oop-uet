public class Pair<K, V> {
	private K key;
	private V value;
	public void setKey(K key) {
		this.key = key;
	}
	public K getKey() {
		return key;
	}

}
Pair<String, Integer> p1 = new Pair<String, Integer>("Even", 8);
