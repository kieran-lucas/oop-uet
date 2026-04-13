import java.util.*;

interface Sorter {
    int[] sort(int[] arr);
}

class LegacySorter {
    public int[] quickSort(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }
}

class SorterAdapter implements Sorter {
    private LegacySorter legacy = new LegacySorter();

    public int[] sort(int[] arr) {
        return legacy.quickSort(arr);
    }
}

class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = new ArrayList<>(sections);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReportTemplate clone() {
        try {
            ReportTemplate copy = (ReportTemplate) super.clone();
            copy.sections = new ArrayList<>(this.sections);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        System.out.println("Title: " + title);
        for (String s : sections) {
            System.out.println("- " + s);
        }
        System.out.println("Footer: " + footer);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Sorter sorter = new SorterAdapter();
        int[] arr = {5, 2, 9, 1, 3};
        int[] sorted = sorter.sort(arr);
        System.out.println(Arrays.toString(sorted));

        List<String> sections = Arrays.asList("Intro", "Content", "Summary");
        ReportTemplate original = new ReportTemplate("Base Report", "Footer", sections);

        ReportTemplate r1 = original.clone();
        ReportTemplate r2 = original.clone();

        r1.setTitle("Report A");
        r2.setTitle("Report B");

        original.print();
        r1.print();
        r2.print();
    }
}