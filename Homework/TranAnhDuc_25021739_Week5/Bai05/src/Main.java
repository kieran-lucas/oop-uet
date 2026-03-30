import java.util.*;

class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + title + " - " + author + " - " + year;
    }
}

// Quan ly bang ArrayList
class LibraryArrayList {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Da them sach: " + book);
    }

    public Book findBook(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    public boolean removeBook(String id) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                System.out.println("Da xoa sach co id: " + id);
                return true;
            }
        }
        return false;
    }

    public void printBooks() {
        System.out.println("=== Danh sach sach (ArrayList) ===");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

// Quan ly bang HashMap
class LibraryHashMap {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Da them sach: " + book);
    }

    public Book findBook(String id) {
        return books.get(id);
    }

    public boolean removeBook(String id) {
        if (books.remove(id) != null) {
            System.out.println("Da xoa sach co id: " + id);
            return true;
        }
        return false;
    }

    public void printBooks() {
        System.out.println("=== Danh sach sach (HashMap) ===");
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }
}

// Quan ly bang TreeMap
class LibraryTreeMap {
    private TreeMap<String, Book> books = new TreeMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Da them sach: " + book);
    }

    public Book findBook(String id) {
        return books.get(id);
    }

    public boolean removeBook(String id) {
        if (books.remove(id) != null) {
            System.out.println("Da xoa sach co id: " + id);
            return true;
        }
        return false;
    }

    public void printBooks() {
        System.out.println("=== Danh sach sach (TreeMap) ===");
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }
}


// Main
public class Main {
    public static void main(String[] args) {
        // Tao 5 cuon sach
        Book b1 = new Book("B001", "Java Co Ban", "Nguyen Van A", 2015);
        Book b2 = new Book("B002", "Cau truc du lieu", "Tran Thi B", 2017);
        Book b3 = new Book("B003", "Giai thuat", "Le Van C", 2016);
        Book b4 = new Book("B004", "He Dieu hanh", "Pham Van D", 2018);
        Book b5 = new Book("B005", "Mang May Tinh", "Hoang Thi E", 2019);

        System.out.println("=== SU DUNG ARRAYLIST ===");
        LibraryArrayList libList = new LibraryArrayList();
        libList.addBook(b1);
        libList.addBook(b2);
        libList.addBook(b3);
        libList.addBook(b4);
        libList.addBook(b5);

        System.out.println("Tim sach B003:");
        System.out.println(libList.findBook("B003"));

        libList.removeBook("B002");
        libList.printBooks();

        System.out.println("\n=== SU DUNG HASHMAP ===");
        LibraryHashMap libMap = new LibraryHashMap();
        libMap.addBook(b1);
        libMap.addBook(b2);
        libMap.addBook(b3);
        libMap.addBook(b4);
        libMap.addBook(b5);

        System.out.println("Tim sach B003:");
        System.out.println(libMap.findBook("B003"));

        libMap.removeBook("B002");
        libMap.printBooks();

        System.out.println("\n=== SU DUNG TREEMAP ===");
        LibraryTreeMap libTree = new LibraryTreeMap();
        libTree.addBook(b1);
        libTree.addBook(b2);
        libTree.addBook(b3);
        libTree.addBook(b4);
        libTree.addBook(b5);

        System.out.println("Tim sach B003:");
        System.out.println(libTree.findBook("B003"));

        libTree.removeBook("B002");
        libTree.printBooks();
    }
}