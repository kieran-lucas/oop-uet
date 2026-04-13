import java.util.*;

class Logger {
    private static volatile Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println("LOG: " + msg);
    }
}

interface Export {
    void export();
}

class PdfExport implements Export {
    public void export() {
        System.out.println("Export PDF");
    }
}

class ExcelExport implements Export {
    public void export() {
        System.out.println("Export Excel");
    }
}

abstract class ExportFactory {
    protected abstract Export createExport();

    public void doExport() {
        Export e = createExport();
        e.export();
    }
}

class PdfExportFactory extends ExportFactory {
    protected Export createExport() {
        return new PdfExport();
    }
}

class ExcelExportFactory extends ExportFactory {
    protected Export createExport() {
        return new ExcelExport();
    }
}

class OldPlayer {
    void playFile(String name) {
        System.out.println("Playing file (old): " + name);
    }
}

interface Player {
    void play(String name);
}

class PlayerAdapter implements Player {
    private OldPlayer oldPlayer = new OldPlayer();

    public void play(String name) {
        oldPlayer.playFile(name);
    }
}

class Config implements Cloneable {
    private String name;
    private List<String> settings;

    public Config(String name, List<String> settings) {
        this.name = name;
        this.settings = new ArrayList<>(settings);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Config clone() {
        try {
            Config copy = (Config) super.clone();
            copy.settings = new ArrayList<>(this.settings);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        System.out.println("Config: " + name + " " + settings);
    }
}

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger1.hashCode());
        System.out.println(logger2.hashCode());
        logger1.log("Singleton working");

        ExportFactory factory = new PdfExportFactory();
        factory.doExport();

        factory = new ExcelExportFactory();
        factory.doExport();

        Player player = new PlayerAdapter();
        player.play("song.mp3");

        Config original = new Config("Base", Arrays.asList("A", "B", "C"));
        Config c1 = original.clone();
        Config c2 = original.clone();

        c1.setName("Config1");
        c2.setName("Config2");

        original.print();
        c1.print();
        c2.print();
    }
}