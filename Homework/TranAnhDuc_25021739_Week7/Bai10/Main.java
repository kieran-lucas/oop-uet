class Worker implements Runnable {
    private volatile boolean running = true; // volatile đảm bảo thay đổi từ thread main được nhìn thấy ngay bởi thread Worker (visibility)

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) { // nếu không có volatile, thread có thể cache biến này và không thấy cập nhật -> vòng lặp vô hạn
            System.out.println("Working...");
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();
        Thread t = new Thread(worker);

        t.start();

        Thread.sleep(1000);

        worker.stop();

        t.join();
    }
}