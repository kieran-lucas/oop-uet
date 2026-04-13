import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Stage1Task implements Callable<List<Integer>> {
    private int[] arr;

    public Stage1Task(int[] arr) {
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
    public List<Integer> call() {
        List<Integer> primes = new ArrayList<>();
        for (int x : arr) {
            if (isPrime(x)) primes.add(x);
        }
        return primes;
    }
}

class Stage2Task implements Callable<Integer> {
    private List<Integer> primes;

    public Stage2Task(List<Integer> primes) {
        this.primes = primes;
    }

    @Override
    public Integer call() {
        int sum = 0;
        if (primes.size() % 2 == 0) {
            for (int x : primes) sum += x * x;
        } else {
            for (int x : primes) sum += x * x * x;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            arrays.add(arr);
        }

        ExecutorService pool1 = Executors.newFixedThreadPool(n);
        ExecutorService pool2 = Executors.newFixedThreadPool(n);
        CompletionService<Integer> completion2 = new ExecutorCompletionService<>(pool2);

        AtomicInteger total = new AtomicInteger(0);
        List<Future<List<Integer>>> futures1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            futures1.add(pool1.submit(new Stage1Task(arrays.get(i))));
        }

        for (int i = 0; i < n; i++) {
            final int idx = i;
            new Thread(() -> {
                try {
                    List<Integer> primes = futures1.get(idx).get();
                    System.out.println("Stage 1 - Array " + idx + ": " + primes);

                    completion2.submit(() -> {
                        int result = 0;
                        if (primes.size() % 2 == 0) {
                            for (int x : primes) result += x * x;
                            System.out.println("Stage 2 - Array " + idx + ": sum of squares = " + result);
                        } else {
                            for (int x : primes) result += x * x * x;
                            System.out.println("Stage 2 - Array " + idx + ": sum of cubes = " + result);
                        }
                        return result;
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < n; i++) {
            Future<Integer> f = completion2.take();
            total.addAndGet(f.get());
        }

        System.out.println("Total = " + total.get());

        pool1.shutdown();
        pool2.shutdown();
    }
}