public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.fibonacci(0));
        System.out.println(s.fibonacci(1));
        System.out.println(s.fibonacci(5));
        System.out.println(s.fibonacci(20));
        System.out.println(s.fibonacci(50));
        System.out.println(s.fibonacci(100));
        System.out.println(Solution.fibonacci(33));
	}
	public static class Solution {
		public long fibonacci(long n) {
			if (n < 0) {
				return -1;
			}
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}

			long a = 0;
			long b = 1;
			for (long i = 2; i <= n; i++) {
				if (Long.MAX_VALUE - b < a) {
					return Long.MAX_VALUE;
				}
			
			long temp = a + b;
			a = b;
			b = temp;
		   }
		   return b;	
		}
	}
}