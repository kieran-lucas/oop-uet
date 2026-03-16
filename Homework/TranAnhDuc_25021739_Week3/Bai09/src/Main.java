import java.util.*;

interface IPayable {
    double getPaymentAmount();
}

abstract class Staff implements IPayable {

    protected String id;
    protected String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class PartTimeStaff extends Staff {

    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }

    public String getName() {
        return name;
    }
}

class Invoice implements IPayable {

    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    public String getItemName() {
        return itemName;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<IPayable> payableList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            if (type.equals("S")) {

                String id = sc.next();
                String name = sc.next();
                int hours = sc.nextInt();
                double rate = sc.nextDouble();

                payableList.add(new PartTimeStaff(id, name, hours, rate));
            }

            else if (type.equals("I")) {

                String item = sc.next();
                int quantity = sc.nextInt();
                double price = sc.nextDouble();

                payableList.add(new Invoice(item, quantity, price));
            }
        }

        double total = 0;

        for (IPayable p : payableList) {

            double payment = p.getPaymentAmount();

            if (p instanceof PartTimeStaff) {

                PartTimeStaff s = (PartTimeStaff) p;
                System.out.println("PartTimeStaff " + s.getName() + " - Payment: " + payment);

            } else if (p instanceof Invoice) {

                Invoice i = (Invoice) p;
                System.out.println("Invoice " + i.getItemName() + " - Payment: " + payment);

            }

            total += payment;
        }

        System.out.println("Total Payment = " + total);
    }
}