import java.util.*;
import java.time.LocalDateTime;

class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class Message {
    private String id;
    private String content;

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return id + ": " + content;
    }
}

class Ticket {
    private String id;
    private String content;
    private LocalDateTime timestamp;

    public Ticket(String id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] Ticket " + id + ": " + content;
    }
}

class CustomerQueue {
    private Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println("Khach " + customer.getName() + " da vao hang doi.");
    }

    public Customer nextCustomer() {
        Customer customer = queue.poll();
        if (customer == null) {
            System.out.println("Khong con khach doi.");
        } else {
            System.out.println("Dang xu ly khach: " + customer.getName());
        }
        return customer;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class MessageHistory {
    private Stack<Message> stack = new Stack<>();

    public void sendMessage(Message message) {
        stack.push(message);
        System.out.println("Gui tin nhan: " + message.getContent());
    }

    public void undoLastMessage() {
        if (!stack.isEmpty()) {
            Message removed = stack.pop();
            System.out.println("Undo tin nhan: " + removed.getContent());
        } else {
            System.out.println("Khong co tin nhan nao de undo.");
        }
    }

    public void viewLastMessage() {
        if (!stack.isEmpty()) {
            System.out.println("Tin nhan cuoi cung: " + stack.peek().getContent());
        } else {
            System.out.println("Khong co tin nhan nao.");
        }
    }

    public void viewAllMessages() {
        System.out.println("=== Lich su tin nhan ===");
        for (Message m : stack) {
            System.out.println(m);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue();
        MessageHistory messageHistory = new MessageHistory();

        Customer customerA = new Customer("C001", "Khach A");
        Customer customerB = new Customer("C002", "Khach B");
        customerQueue.addCustomer(customerA);
        customerQueue.addCustomer(customerB);

        Customer current = customerQueue.nextCustomer();
        if (current != null) {
            messageHistory.sendMessage(new Message("M001", "Chao ban, toi co the giup gi?"));
            messageHistory.sendMessage(new Message("M002", "Ban gap van de gi voi don hang?"));
            messageHistory.sendMessage(new Message("M003", "Vui long cung cap ma don hang."));
            
            messageHistory.undoLastMessage();
            messageHistory.viewLastMessage();
        }

        System.out.println();

        current = customerQueue.nextCustomer();
        if (current != null) {
            messageHistory.sendMessage(new Message("M004", "Xin chao Khach B, ban can ho tro gi?"));
            messageHistory.viewLastMessage();
        }

        System.out.println();
        messageHistory.viewAllMessages();
    }
}