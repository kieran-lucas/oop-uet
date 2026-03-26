import java.io.*;

public class Main13 {
    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(reader);

        try {
            String str = buf.readLine();
            int num = Integer.valueOf(str);
            System.out.println("So vua nhap: " + num);

        } catch (IOException e) {
            System.err.println("IO Exception");

        } catch (NumberFormatException e) {
            System.err.println("Nhap khong phai so");

        } finally {
            try {
                buf.close();
            } catch (IOException e) {
                System.err.println("Error closing buffer");
            }
        }
    }
}