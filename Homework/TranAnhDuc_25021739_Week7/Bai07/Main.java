import java.util.*;
import java.util.concurrent.*;

class PrimeCountTask implements Callable<Integer> {
    private int[] arr;

    public PrimeCountTask(int[] arr) {
        this.arr = arr;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    @Override
    public Integer call() {
        int count = 0;
        for (int x : arr) {
            if (isPrime(x)) count++;
        }
        return count;
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
            futures.add(executor.submit(new PrimeCountTask(arr)));
        }

        int[] results = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            results[i] = futures.get(i).get();
            if (results[i] > max) {
                max = results[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Array " + i + ": " + results[i]);
        }

        System.out.print("Most primes:");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (results[i] == max) {
                if (first) {
                    System.out.print(" Array " + i + " with " + max + " primes");
                    first = false;
                } else {
                    System.out.print(", Array " + i);
                }
            }
        }
        System.out.println();

        executor.shutdown();
    }
}