import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class OrderTask implements Callable<Boolean> {
    private String id;
    private long processMs;
    private List<String> logs;

    public OrderTask(String id, long processMs, List<String> logs) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
    }

    @Override
    public Boolean call() {
        System.out.println("Start " + id);
        try {
            Thread.sleep(processMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean success = processMs <= 1500;

        synchronized (logs) {
            if (success) {
                logs.add("DONE " + id);
            } else {
                logs.add("FAIL " + id);
            }
        }

        return success;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        List<String> logs = new ArrayList<>();
        AtomicInteger successCount = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String id = sc.next();
            long processMs = sc.nextLong();
            futures.add(executor.submit(new OrderTask(id, processMs, logs)));
        }

        for (Future<Boolean> f : futures) {
            if (f.get()) {
                successCount.incrementAndGet();
            }
        }

        System.out.println("Success = " + successCount.get());

        for (String log : logs) {
            System.out.println(log);
        }

        executor.shutdown();
    }
}