import java.util.*;

abstract class Employee {

    String name;

    public Employee(String name) {
        this.name = name;
    }

    abstract double getSalary();
    abstract String getType();
}

class FullTimeEmployee extends Employee {

    double baseSalary;
    double bonus;
    double penalty;

    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    @Override
    double getSalary() {
        return baseSalary + (bonus - penalty);
    }

    @Override
    String getType() {
        return "Full-time";
    }
}

class PartTimeEmployee extends Employee {

    double workingHours;
    double hourlyRate;

    public PartTimeEmployee(String name, double workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double getSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    String getType() {
        return "Part-time";
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            if (type.equals("F")) {

                String name = sc.next();
                double base = sc.nextDouble();
                double bonus = sc.nextDouble();
                double penalty = sc.nextDouble();

                employees[i] = new FullTimeEmployee(name, base, bonus, penalty);

            } else {

                String name = sc.next();
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();

                employees[i] = new PartTimeEmployee(name, hours, rate);
            }
        }

        for (Employee e : employees) {
            System.out.println(e.name + " - " + e.getType() + " - " + e.getSalary());
        }
    }
}