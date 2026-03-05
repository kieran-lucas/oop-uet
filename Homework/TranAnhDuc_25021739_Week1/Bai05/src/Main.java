public class Main {
	public static class Solution {
		public int gcd(int a, int b) {
			if (b == 0) {
				return a;
			}
			return gcd(b, a % b);

		}
}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.gcd(4, 6));
		System.out.println(s.gcd(0, 66));
		System.out.println(s.gcd(23, 63));
		System.out.println(s.gcd(976, 0));



	}
}