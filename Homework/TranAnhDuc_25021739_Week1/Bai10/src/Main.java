public class Main {
    public static class Solution {
        public int secondLargest(int[] arr) {
            if (arr == null || arr.length < 2) {
                return -1;
            }

            int max = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            boolean foundSecond = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    second = max;
                    max = arr[i];
                    foundSecond = true;
                }
                else if (arr[i] > second && arr[i] < max) {
                    second = arr[i];
                    foundSecond = true;
                }
            }

            if (foundSecond) {
                return second;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] a = {1, 5, 3, 9, 7};
        int[] b = {5, 5, 5};
        int[] c = {10};
        int[] d = {2, 2, 1};

        System.out.println(s.secondLargest(a));
        System.out.println(s.secondLargest(c));
        System.out.println(s.secondLargest(d));
    }
}