public class Main {


    static final class Transaction {
        private final String transactionId;
        private final double amount;
        private final String timestamp;

        public Transaction(String transactionId, double amount, String timestamp) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.timestamp = timestamp;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public double getAmount() {
            return amount;
        }

        public String getTimestamp() {
            return timestamp;
        }
    }


    static class Account {
        private String accountId;
        private double balance;
        private Transaction[] history;
        private int count = 0;

        public Account(String accountId, double balance, int size) {
            this.accountId = accountId;
            this.balance = balance;
            history = new Transaction[size];
        }

        public void addTransaction(Transaction t) {
            if (count < history.length) {
                history[count++] = t;
            }
        }

        public Transaction[] getHistory() {

            // Deep copy
            Transaction[] copy = new Transaction[count];

            for (int i = 0; i < count; i++) {
                Transaction t = history[i];

                copy[i] = new Transaction(
                        t.getTransactionId(),
                        t.getAmount(),
                        t.getTimestamp()
                );
            }

            return copy;
        }
    }

    public static void main(String[] args) {

        Account acc = new Account("ACC001", 1000, 10);

        acc.addTransaction(new Transaction("T1", 500, "10:00"));
        acc.addTransaction(new Transaction("T2", 300, "11:00"));

        Transaction[] history = acc.getHistory();


        history[0] = new Transaction("T1", 9999999, "10:00");
        history[1] = null;

 
        Transaction[] realHistory = acc.getHistory();

        System.out.println("Real history in Account:");

        for (Transaction t : realHistory) {
            if (t != null) {
                System.out.println(
                        t.getTransactionId() + " " +
                        t.getAmount() + " " +
                        t.getTimestamp()
                );
            }
        }
    }
}