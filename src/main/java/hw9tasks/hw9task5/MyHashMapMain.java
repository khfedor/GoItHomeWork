package hw9tasks.hw9task5;

public class MyHashMapMain {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("P", 1);     //путня - відро;
        map.put("U", 2);
        map.put("T", 3);
        map.put("N", 4);
        map.put("I", 5);
        map.put("A", 5);

        System.out.println("Size: " + map.size());

        System.out.println("Get 'T': " + map.get("T"));

        map.remove("T");
        System.out.println("Size after removing 'T': " + map.size());

        map.clear();
        System.out.println("Size after clearing: " + map.size());
    }
}
