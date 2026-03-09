public class Main {

    static class Person {

        private String name;
        private Person me;

        public Person(String name) {
            this.name = name;
        }

        public void setMe(Person other) {
            this.me = other; 
        }

        public Person getMe() {
            return me;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        Person p = new Person("Alice");

        p.setMe(p);

        System.out.println(p.getMe().getName());

        p = null;

    }
}