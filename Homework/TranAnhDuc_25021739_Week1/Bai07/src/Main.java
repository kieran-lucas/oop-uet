public class Main {
	public static class Solution {
		public int reverse(int n) {
			int res = 0;
			while (n != 0) {
				int digit = n % 10;
				n = n / 10;
				if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
    				return 0;
				}
				res = res * 10 + digit;

			}
			return res;

		}
	}
	public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-456));
        System.out.println(s.reverse(1200));
        System.out.println(s.reverse(1534236469)); 
    }
}