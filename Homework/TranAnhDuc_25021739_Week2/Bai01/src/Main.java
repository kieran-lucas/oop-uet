public class Main {

    static class BankAccount {
        private String accountNumber;
        private double balance;
        private String ownerName;

        public BankAccount(String accountNumber, String ownerName) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = 0;
        }

        public BankAccount(String accountNumber, double balance, String ownerName) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;

            if (balance < 0) {
                this.balance = 0;
            } else {
                this.balance = balance;
            }
        }

        void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
            }
        }

        boolean withdraw(double amount) {
            if (amount > 0 && amount <= this.balance) {
                this.balance -= amount;
                return true;
            }
            return false;
        }

        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {

        BankAccount b = new BankAccount("123", 1000, "Anh Duc");

        System.out.println(b.getBalance());

        b.deposit(-100);
        System.out.println(b.getBalance());

        System.out.println(b.withdraw(1100));
        System.out.println(b.getBalance());

        b.withdraw(500);
        System.out.println(b.getBalance());
    }
}