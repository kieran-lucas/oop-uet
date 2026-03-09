public class Main {

    static class Product {
        private String id;
        private String name;
        private double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Inventory {
        private Product[] items;

        public Inventory(Product[] initialItems) {

            items = new Product[initialItems.length];

            for (int i = 0; i < initialItems.length; i++) {
                Product p = initialItems[i];

                items[i] = new Product(
                        p.getId(),
                        p.getName(),
                        p.getPrice()
                );
            }
        }

        public void printInventory() {
            for (Product p : items) {
                System.out.println(
                        p.getId() + " - " +
                        p.getName() + " - $" +
                        p.getPrice()
                );
            }
        }
    }

    public static void main(String[] args) {

        Product[] arr = new Product[2];

        arr[0] = new Product("P1", "Laptop", 1000);
        arr[1] = new Product("P2", "Mouse", 50);

        Inventory kho = new Inventory(arr);

        arr[0].setPrice(5000);

        System.out.println("Inventory products:");
        kho.printInventory();
    }
}