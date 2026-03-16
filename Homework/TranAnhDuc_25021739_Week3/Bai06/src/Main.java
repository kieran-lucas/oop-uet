import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

abstract class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract double getFinalPrice();
    abstract String getType();
}

class Electronics extends Product {

    double warrantyFee;

    public Electronics(String name, double price, double warrantyFee) {
        super(name, price);
        this.warrantyFee = warrantyFee;
    }

    @Override
    double getFinalPrice() {
        return price * 1.1 + warrantyFee;
    }

    @Override
    String getType() {
        return "Electronics";
    }
}

class Food extends Product {

    LocalDate expiryDate;

    public Food(String name, double price, LocalDate expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    double getFinalPrice() {

        long days = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);

        if (days < 7) {
            return price * 0.8;
        }

        return price;
    }

    @Override
    String getType() {
        return "Food";
    }
}

class Order {

    List<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    void printOrder() {

        double total = 0;

        for (Product p : products) {

            double finalPrice = p.getFinalPrice();
            total += finalPrice;

            System.out.println(
                p.name + " - " + p.getType() + " - " + finalPrice
            );
        }

        System.out.println("Total = " + total);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Order order = new Order();

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            if (type.equals("E")) {

                String name = sc.next();
                double price = sc.nextDouble();
                double fee = sc.nextDouble();

                order.addProduct(new Electronics(name, price, fee));

            } else if (type.equals("F")) {

                String name = sc.next();
                double price = sc.nextDouble();
                String date = sc.next();

                LocalDate expiry = LocalDate.parse(date);

                order.addProduct(new Food(name, price, expiry));
            }
        }

        order.printOrder();
    }
}