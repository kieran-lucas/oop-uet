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
		public boolean isPalindrome(int n) {
			if (n < 0) {
				return false;
			}
			if (n == reverse(n)) {
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(12321));
        System.out.println(s.isPalindrome(123));
        System.out.println(s.isPalindrome(-121));
        System.out.println(s.isPalindrome(10));
    }

}