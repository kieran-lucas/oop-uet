import java.util.*;
import java.util.concurrent.*;

class SumTask implements Callable<Integer> {
    private int[] arr;
    private int start;
    private int end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = 4;
        ExecutorService executor = Executors.newFixedThreadPool(k);
        List<Future<Integer>> futures = new ArrayList<>();

        int chunkSize = (n + k - 1) / k;

        for (int i = 0; i < k; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n);
            if (start >= n) break;
            futures.add(executor.submit(new SumTask(arr, start, end)));
        }

        int total = 0;
        for (Future<Integer> f : futures) {
            total += f.get();
        }

        System.out.println(total);

        executor.shutdown();
    }
}