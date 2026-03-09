public class Main {
    static class Student {
        private String id;
        private String name;
        private String email;
        private double gpa;

        public Student() {
        }

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student(String id, String name, String email, double gpa) {
            this.id = id;
            this.name = name;
            this.email = email;
            setGPA(gpa);
        }

        public void setID(String id) {
            this.id = id;
        }

        public String getID() {
            return this.id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return this.email;
        }

        public void setGPA(double gpa) {
            if (gpa >= 0.0 && gpa <= 4.0) {
                this.gpa = gpa;
            } else {
                System.out.println("GPA khong hop le");
            }
        }

        public double getGPA() {
            return this.gpa;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setID("001");
        s1.setName("An");
        s1.setEmail("an@gmail.com");
        s1.setGPA(-3.0);

        Student s2 = new Student("002", "Binh");
        s2.setEmail("binh@gmail.com");
        s2.setGPA(3.2);

        Student s3 = new Student("003", "Cuong", "cuong@gmail.com", 3.8);

        System.out.println(s1.getID() + " " + s1.getName() + " " + s1.getEmail() + " " + s1.getGPA());
        System.out.println(s2.getID() + " " + s2.getName() + " " + s2.getEmail() + " " + s2.getGPA());
        System.out.println(s3.getID() + " " + s3.getName() + " " + s3.getEmail() + " " + s3.getGPA());
    }
}