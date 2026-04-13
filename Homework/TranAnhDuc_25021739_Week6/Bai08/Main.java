class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

interface ReportFormatter {
    String format(Report report);
}

class JsonFormatter implements ReportFormatter {
    public String format(Report report) {
        return "{ \"title\": \"" + report.getTitle() +
               "\", \"content\": \"" + report.getContent() + "\" }";
    }
}

class XmlFormatter implements ReportFormatter {
    public String format(Report report) {
        return "<report><title>" + report.getTitle() +
               "</title><content>" + report.getContent() +
               "</content></report>";
    }
}

class ReportService {
    private ReportFormatter formatter;

    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        return formatter.format(data);
    }
}

public class Main {
    public static void main(String[] args) {

        Report report = new Report("Demo", "Hello OCP");

        ReportFormatter formatter = new JsonFormatter();
        // formatter = new XmlFormatter();

        ReportService service = new ReportService(formatter);

        String result = service.export(report);
        System.out.println(result);
    }
}