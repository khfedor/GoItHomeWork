package dimatest;

public class Tester {
    static Person p = null;

    public static void main(String[] args) {
        p = checkPerson(p);
        System.out.println(p);

        Person pl = new Person("Joe");
        p = checkPerson(pl);
        System.out.println(p);
    }

    public static Person checkPerson(Person p) {
        if (p == null) {
            p = new Person("Mary");
        }
        return p;
    }
}
