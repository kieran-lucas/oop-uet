import java.util.*;
abstract class MediaItem {
	private String id;
	private String name;
	public MediaItem(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public abstract void getInfor();

}
class Book extends MediaItem {
	private String author;
	private int pageCount;
	public Book(String id, String name, String author, int pageCount) {
		super(id, name);
		this.author = author;
		this.pageCount = pageCount;
	}
	public void getInfor() {
		System.out.println(getName() + " - " + author + " - " + pageCount);

	}
}
class DVD extends MediaItem {
	private String director;
	private int duration;
	public DVD(String id, String name, String director, int duration) {
		super(id, name);
		this.director = director;
		this.duration = duration;
	}
	public void getInfor() {
		System.out.println(getName() + " - " + director + " - " + duration);
	}

}
class LibrarySection<T extends MediaItem> {
	private List<T> book = new ArrayList<T>();
	private List<T> dvd = new ArrayList<T>();

	public void addDoc(T doc) {
		if (doc instanceof Book) {
			book.add(doc);
		} else if (doc instanceof DVD) {
			dvd.add(doc);
		}
	}
	public void removeDoc(String id) {
		book.removeIf(doc -> doc.getID().equals(id));
		dvd.removeIf(doc -> doc.getID().equals(id));
	}
	public void printLibaray() {
		System.out.println("Khu vuc sach: ");
		for (T doc : book) {
			doc.getInfor();
		}
		System.out.println("Khu vuc DVD: ");
		for (T doc : dvd) {
			doc.getInfor();
		}

	}

}
public class Main {
	public static void main(String[] args) {
		LibrarySection<MediaItem> lib = new LibrarySection<MediaItem>();
		lib.addDoc(new Book("001", "Calculus", "James Stewart", 1200));
		lib.addDoc(new Book("002", "Java Core", "Cay S. Horstmann", 800));
		lib.addDoc(new DVD("003", "Inception", "Christopher Nolan", 148));
		lib.addDoc(new DVD("004", "Titanic", "James Cameron", 195));
		lib.printLibaray();
		lib.removeDoc("003");
		System.out.println();
		System.out.println("Sau khi xoa: ");
		lib.printLibaray();



	}
}