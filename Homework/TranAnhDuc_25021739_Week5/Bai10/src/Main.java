import java.io.*;
import java.util.*;

class InvalidConfigException extends Exception {
	public InvalidConfigException(String message) {
		super(message);
	}
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap duong dan file config: ");
        String path = sc.nextLine();

        BufferedReader br = null;
        Map<String, String> config = new HashMap<>();

        try {
            br = new BufferedReader(new FileReader(path));

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("=");
                if (parts.length != 2) {
                    throw new InvalidConfigException("Sai dinh dang dong: " + line);
                }

                String key = parts[0].trim();
                String value = parts[1].trim();

                config.put(key, value);
            }

            if (!config.containsKey("username")) {
                throw new InvalidConfigException("Thieu username");
            }

            if (!config.containsKey("timeout")) {
                throw new InvalidConfigException("Thieu timeout");
            }

            int timeout = Integer.parseInt(config.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("timeout phai > 0");
            }

            if (config.containsKey("maxConnections")) {
                int max = Integer.parseInt(config.get("maxConnections"));
                if (max < 1) {
                    throw new InvalidConfigException("maxConnections phai >= 1");
                }
            }

            System.out.println("Config loaded successfully.");
            for (Map.Entry<String, String> entry : config.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                	br.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }

        System.out.println("Program finished.");
    }
}