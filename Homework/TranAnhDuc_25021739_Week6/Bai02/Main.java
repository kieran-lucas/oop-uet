interface Notification {
    void send(String msg);
}

class EmailNotification implements Notification {
    public void send(String msg) {
        System.out.println("Send EMAIL: " + msg);
    }
}

class SmsNotification implements Notification {
    public void send(String msg) {
        System.out.println("Send SMS: " + msg);
    }
}

abstract class NotificationApp {
    protected abstract Notification createNotification();

    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }
}

class EmailApp extends NotificationApp {
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsApp extends NotificationApp {
    protected Notification createNotification() {
        return new SmsNotification();
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationApp app;
        app = new EmailApp();
        // app = new SmsApp();
        app.notifyUser("Hello Factory Method!");
    }
}