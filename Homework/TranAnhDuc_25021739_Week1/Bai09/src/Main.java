public class Main {
	public static class Solution {
		public int sumOfDigits(int n) {
			if (n < 0) {
				n = -n;
			}
			int res = 0;
			while (n > 0) {
				res += n % 10;
				n = n / 10;
			}
			return res;

		}
	}
	 public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.sumOfDigits(1234));  
        System.out.println(s.sumOfDigits(0));     
        System.out.println(s.sumOfDigits(-567));  
        System.out.println(s.sumOfDigits(99999)); 
    }
}