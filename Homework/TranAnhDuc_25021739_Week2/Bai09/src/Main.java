import java.util.Scanner;

public class Main {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0.0;
    
    public Main(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }
    
    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }
    
    public double calculateFinalPrice() {
        double priceAfterDiscount = price - discount;
        return priceAfterDiscount * (1 + taxRate);
    }
    
    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }
    
    public void sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            double revenue = amount * calculateFinalPrice();
            totalRevenue += revenue;
            System.out.println("Da ban thanh cong " + amount + " " + name);
        } else {
            System.err.println("Khong du hang trong kho cho san pham " + name);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public static double getTotalRevenue() {
        return totalRevenue;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nhap thong tin cho san pham thu nhat:");
        System.out.print("Ten san pham: ");
        String name1 = scanner.nextLine();
        System.out.print("Gia: ");
        double price1 = scanner.nextDouble();
        System.out.print("So luong ton kho: ");
        int quantity1 = scanner.nextInt();
        System.out.print("Giam gia: ");
        double discount1 = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("\nNhap thong tin cho san pham thu hai:");
        System.out.print("Ten san pham: ");
        String name2 = scanner.nextLine();
        System.out.print("Gia: ");
        double price2 = scanner.nextDouble();
        System.out.print("So luong ton kho: ");
        int quantity2 = scanner.nextInt();
        System.out.print("Giam gia: ");
        double discount2 = scanner.nextDouble();
        
        Main p1 = new Main(name1, price1, quantity1, discount1);
        Main p2 = new Main(name2, price2, quantity2, discount2);
        
        System.out.println("\n--- THUC HIEN GIAO DICH ---");
        System.out.print("Nhap so luong can mua cho " + p1.getName() + ": ");
        int amount1 = scanner.nextInt();
        p1.sell(amount1);
        
        System.out.print("Nhap so luong can mua cho " + p2.getName() + ": ");
        int amount2 = scanner.nextInt();
        p2.sell(amount2);
        
        System.out.println("\n--- KIEM TRA TINH CHAT STATIC ---");
        
        System.out.println("Gia cuoi cung cua " + p1.getName() + ": " + p1.calculateFinalPrice());
        System.out.println("Gia cuoi cung cua " + p2.getName() + ": " + p2.calculateFinalPrice());
        
        System.out.println("\nCap nhat thue VAT xuong 8%...");
        Main.updateTaxRate(0.08);
        
        System.out.println("Gia cuoi cung cua " + p1.getName() + " sau khi giam thue: " + p1.calculateFinalPrice());
        System.out.println("Gia cuoi cung cua " + p2.getName() + " sau khi giam thue: " + p2.calculateFinalPrice());
        
        System.out.println("\nCap nhat giam gia cho " + p1.getName() + " thanh 10.0...");
        p1.updateDiscount(10.0);
        
        System.out.println("Gia cuoi cung cua " + p1.getName() + " sau khi cap nhat giam gia: " + p1.calculateFinalPrice());
        System.out.println("Gia cuoi cung cua " + p2.getName() + " sau khi cap nhat giam gia cho p1: " + p2.calculateFinalPrice());
        
        System.out.println("\n--- TONG DOANH THU ---");
        System.out.println("Tong doanh thu toan he thong: " + Main.getTotalRevenue());
        
        scanner.close();
    }
}