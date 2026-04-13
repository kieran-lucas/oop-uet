interface Notifier {
    void send(String msg);
}

class EmailNotifier implements Notifier {
    public void send(String msg) {
        System.out.println("Send EMAIL: " + msg);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    public NotifierDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }

    public void send(String msg) {
        wrappee.send(msg);
    }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    public void send(String msg) {
        super.send(msg);
        System.out.println("Send SMS: " + msg);
    }
}

class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }

    public void send(String msg) {
        super.send(msg);
        System.out.println("Send Facebook: " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifier(
                                new FacebookNotifier(
                                    new EmailNotifier()
                                )
                             );

        notifier.send("Hello Decorator!");
    }
}