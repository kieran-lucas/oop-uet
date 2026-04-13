import java.util.*;

interface FileSystemItem {
    void print(String indent);
    String getPath();
}

class FileItem implements FileSystemItem {
    private String name;
    private int size;
    private String path;

    public FileItem(String name, int size, String parentPath) {
        this.name = name;
        this.size = size;
        this.path = parentPath + "/" + name;
    }

    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }

    public String getPath() {
        return path;
    }
}

class Shortcut implements FileSystemItem {
    private String name;
    private FileSystemItem target;
    private String path;

    public Shortcut(String name, FileSystemItem target, String parentPath) {
        this.name = name;
        this.target = target;
        this.path = parentPath + "/" + name;
    }

    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + name + " -> " + target.getPath());
    }

    public String getPath() {
        return path;
    }
}

class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();
    private String path;

    public Folder(String name, String parentPath) {
        this.name = name;
        this.path = parentPath + "/" + name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem item : children) {
            item.print(indent + "  ");
        }
    }

    public String getPath() {
        return path;
    }
}

public class Main {
    public static void main(String[] args) {

        Folder root = new Folder("root", "");
        Folder docs = new Folder("docs", root.getPath());

        FileItem a = new FileItem("a.txt", 12, docs.getPath());
        FileItem b = new FileItem("b.txt", 8, docs.getPath());

        Shortcut s = new Shortcut("a-shortcut", a, docs.getPath());

        docs.add(a);
        docs.add(b);
        docs.add(s);

        FileItem readme = new FileItem("readme.md", 4, root.getPath());

        root.add(docs);
        root.add(readme);

        root.print("");
    }
}