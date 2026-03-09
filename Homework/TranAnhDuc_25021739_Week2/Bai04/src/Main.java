public class Main {

    static class MyDate {
        private int day;
        private int month;
        private int year;

        public MyDate(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public MyDate(MyDate other) {
            this.day = other.day;
            this.month = other.month;
            this.year = other.year;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }
    }

    static class Employee {
        private String name;
        private MyDate birthday;

        public Employee(String name, MyDate birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public Employee(Employee other) {
            this.name = other.name;
            this.birthday = new MyDate(other.birthday);
        }

        public MyDate getBirthday() {
            return birthday;
        }
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee("A", new MyDate(1, 1, 2000));

        Employee emp2 = new Employee(emp1);

        emp1.getBirthday().setDay(2);
        emp1.getBirthday().setMonth(2);
        emp1.getBirthday().setYear(2022);

        System.out.println(emp2.getBirthday().getDay() + "/" +
                           emp2.getBirthday().getMonth() + "/" +
                           emp2.getBirthday().getYear());
    }
}