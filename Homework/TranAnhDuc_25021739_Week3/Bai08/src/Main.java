import java.util.*;

abstract class Robot {

    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
        this.batteryLevel = 0;
    }

    public void chargeBattery() {
        batteryLevel = 100;
    }

    public final void showIdentity() {
        System.out.println("ID: " + id + " Model: " + modelName);
    }

    public String getModelName() {
        return modelName;
    }

    abstract void performMainTask();
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface GPS {
    void getCoordinates();
}

class DroneRobot extends Robot implements Flyable, GPS {

    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}

class FishRobot extends Robot implements Swimmable {

    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void swim() {
        System.out.println(getModelName() + " swimming");
    }
}

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {

    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    @Override
    public void swim() {
        System.out.println(getModelName() + " swimming");
    }

    @Override
    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int id = sc.nextInt();
            String model = sc.next();

            if (type.equals("DR")) {
                robots.add(new DroneRobot(id, model));
            }
            else if (type.equals("FR")) {
                robots.add(new FishRobot(id, model));
            }
            else if (type.equals("AR")) {
                robots.add(new AmphibiousRobot(id, model));
            }
        }

        for (Robot r : robots) {

            r.performMainTask();

            if (r instanceof Flyable) {
                ((Flyable) r).fly();
            }

            if (r instanceof Swimmable) {
                ((Swimmable) r).swim();
            }

            if (r instanceof GPS) {
                ((GPS) r).getCoordinates();
            }

            System.out.println();
        }
    }
}