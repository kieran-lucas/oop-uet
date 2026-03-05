public class Main {
	public static class Solution {
		public boolean isPrime(int n) {
			if (n < 2) {
				return false;
			}
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPrime(-9));
		System.out.println(s.isPrime(0));
		System.out.println(s.isPrime(1));
		System.out.println(s.isPrime(17));
		System.out.println(s.isPrime(937));
	}
}