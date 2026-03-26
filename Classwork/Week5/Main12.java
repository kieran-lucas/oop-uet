public class Main12 {
    public static void main(String[] args) {
        try {
            int x = 10 / 0; // lỗi ArithmeticException
        } 
        catch (Exception e) {
            System.out.println("Bắt bởi Exception");
        } 
        catch (ArithmeticException e) {
            System.out.println("Bắt bởi ArithmeticException");
        }
    }
}