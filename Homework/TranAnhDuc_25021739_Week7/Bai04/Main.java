import java.util.*;
import java.util.concurrent.locks.*;

class BookStore {
    private Map<String, Integer> stock = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public int getStock(String title) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading " + title);
            return stock.getOrDefault(title, 0);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addBook(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " adding " + title);
            stock.put(title, stock.getOrDefault(title, 0) + qty);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " borrowing " + title);
            int current = stock.getOrDefault(title, 0);
            if (current >= qty) {
                stock.put(title, current - qty);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BookStore store = new BookStore();

        store.addBook("Java", 10);
        store.addBook("Python", 8);
        store.addBook("C++", 5);

        Runnable reader = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() +
                        " stock Java = " + store.getStock("Java"));
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        };

        Runnable writer1 = () -> {
            for (int i = 0; i < 3; i++) {
                store.borrow("Java", 1);
                try { Thread.sleep(150); } catch (InterruptedException e) {}
            }
        };

        Runnable writer2 = () -> {
            for (int i = 0; i < 3; i++) {
                store.addBook("Java", 2);
                try { Thread.sleep(150); } catch (InterruptedException e) {}
            }
        };

        Thread r1 = new Thread(reader, "Reader-1");
        Thread r2 = new Thread(reader, "Reader-2");
        Thread r3 = new Thread(reader, "Reader-3");

        Thread w1 = new Thread(writer1, "Writer-1");
        Thread w2 = new Thread(writer2, "Writer-2");

        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();

        r1.join();
        r2.join();
        r3.join();
        w1.join();
        w2.join();
    }
}