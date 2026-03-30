import java.util.*;


abstract class SmartDevice {
    private String id;
    private String name;
    private String status;

    public SmartDevice(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void turnOn() {
        status = "on";
    }

    public void turnOff() {
        status = "off";
    }
}

interface WifiConnectable {
    void connectWifi();
}


interface Adjustable {
    void increaseLevel(int amount);
    void decreaseLevel(int amount);
}


class SmartLight extends SmartDevice implements Adjustable {
    private int brightness;

    public SmartLight(String id, String name, String status, int brightness) {
        super(id, name, status);
        this.brightness = brightness;
    }

    @Override
    public void increaseLevel(int amount) {
        brightness += amount;
        System.out.println(getName() + " brightness increased to " + brightness);
    }

    @Override
    public void decreaseLevel(int amount) {
        brightness -= amount;
        System.out.println(getName() + " brightness decreased to " + brightness);
    }
}


class AirConditioner extends SmartDevice implements WifiConnectable {
    public AirConditioner(String id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void connectWifi() {
        System.out.println(getName() + " connected to wifi");
    }
}


class SmartSpeaker extends SmartDevice implements Adjustable, WifiConnectable {
    private int volumeLevel;

    public SmartSpeaker(String id, String name, String status, int volumeLevel) {
        super(id, name, status);
        this.volumeLevel = volumeLevel;
    }

    @Override
    public void increaseLevel(int amount) {
        volumeLevel += amount;
        System.out.println(getName() + " volume increased to " + volumeLevel);
    }

    @Override
    public void decreaseLevel(int amount) {
        volumeLevel -= amount;
        System.out.println(getName() + " volume decreased to " + volumeLevel);
    }

    @Override
    public void connectWifi() {
        System.out.println(getName() + " connected to wifi");
    }
}


class AutomaticCurtains extends SmartDevice {
    public AutomaticCurtains(String id, String name, String status) {
        super(id, name, status);
    }
}


class Hub {
    public void turnOffAll(List<SmartDevice> devices) {
        System.out.println("Turn Off All Devices:");
        for (SmartDevice device : devices) {
            device.turnOff();
            System.out.println(device.getName() + " turned off");
        }
    }

    public void setupWifi(List<SmartDevice> devices) {
        System.out.println("\nSetup Wifi:");
        for (SmartDevice device : devices) {
            if (device instanceof WifiConnectable wc) {
                wc.connectWifi();
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SmartDevice> devices = new ArrayList<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("L")) { 
                int brightness = sc.nextInt();
                sc.nextLine();
                devices.add(new SmartLight(id, name, "on", brightness));
            } else if (type.equals("AC")) { 
                devices.add(new AirConditioner(id, name, "on"));
            } else if (type.equals("S")) { 
                int volume = sc.nextInt();
                sc.nextLine();
                devices.add(new SmartSpeaker(id, name, "on", volume));
            } else if (type.equals("C")) { 
                devices.add(new AutomaticCurtains(id, name, "on"));
            }
        }

        Hub hub = new Hub();
        hub.turnOffAll(devices);
        hub.setupWifi(devices);
    }
}