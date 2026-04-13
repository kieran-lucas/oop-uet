import java.util.*;
import java.util.concurrent.*;

class SecondLargestTask implements Callable<Integer> {
    private int[] arr;

    public SecondLargestTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() {
        if (arr.length < 2) return null;

        Integer max = null;
        Integer second = null;

        for (int x : arr) {
            if (max == null || x > max) {
                if (max != null && !xEquals(x, max)) {
                    second = max;
                }
                max = x;
            } else if (!xEquals(x, max)) {
                if (second == null || x > second) {
                    second = x;
                }
            }
        }

        return second;
    }

    private boolean xEquals(int a, int b) {
        return a == b;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(n);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            futures.add(executor.submit(new SecondLargestTask(arr)));
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            Integer result = null;
            try {
                result = futures.get(i).get();
            } catch (Exception e) {
                result = null;
            }

            if (result == null) {
                System.out.println("Array " + i + ": Not found");
            } else {
                System.out.println("Array " + i + ": second largest = " + result);
                sum += result;
            }
        }

        System.out.println("Sum = " + sum);

        executor.shutdown();
    }
}