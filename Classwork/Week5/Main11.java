import java.util.*;
import java.io.*;

public class Main11 {
    public static void main(String[] args) {
        try {
            File file = new File("DATA.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!");
        }
    }
}