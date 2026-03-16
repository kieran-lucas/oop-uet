import java.util.*;

abstract class Room {

    int nights;

    public Room(int nights) {
        this.nights = nights;
    }

    abstract double calculatePrice();
}

class StandardRoom extends Room {

    public StandardRoom(int nights) {
        super(nights);
    }

    @Override
    double calculatePrice() {

        double total = nights * 500000;

        if (nights > 3) {
            total = total * 0.95;
        }

        return total;
    }
}

class VipRoom extends Room {

    public VipRoom(int nights) {
        super(nights);
    }

    @Override
    double calculatePrice() {
        return nights * 2000000;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String type = sc.next();
        int nights = sc.nextInt();

        Room room;

        if (type.equals("S")) {
            room = new StandardRoom(nights);
        } else {
            room = new VipRoom(nights);
        }

        System.out.println((long)room.calculatePrice());
    }
}