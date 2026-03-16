import java.util.*;

class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.1;
    }

    public String getName() {
        return name;
    }
}

class Developer extends Employee {

    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.1 + overtimeHours * 200000;
    }
}

class Tester extends Employee {

    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.1 + bugsFound * 50000;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            if (type.equals("E")) {

                String name = sc.next();
                double salary = sc.nextDouble();

                list.add(new Employee(name, salary));
            }

            else if (type.equals("D")) {

                String name = sc.next();
                double salary = sc.nextDouble();
                int overtime = sc.nextInt();

                list.add(new Developer(name, salary, overtime));
            }

            else if (type.equals("T")) {

                String name = sc.next();
                double salary = sc.nextDouble();
                int bugs = sc.nextInt();

                list.add(new Tester(name, salary, bugs));
            }
        }

        for (Employee e : list) {

            double bonus = e.calculateBonus();

            System.out.println(e.getName() + " - Bonus: " + bonus);

            if (e instanceof Developer) {
                System.out.println("Tang khoa hoc AWS");
            }

            if (e instanceof Tester) {
                System.out.println("Tang tool Test");
            }

            System.out.println();
        }
    }
}