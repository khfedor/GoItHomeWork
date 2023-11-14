package hw9task2;

public class MyArrayListMain {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.add("A");   //андрути - вафельний торт зі згущеним молоком;
        myList.add("n");
        myList.add("d");
        myList.add("r");
        myList.add("u");
        myList.add("t");
        myList.add("y");

        myList.add("!");

        for (int i = 0; i < myList.size(); i++) {
            System.err.print(myList.get(i) + "");
        }

        System.out.println();
        System.out.println("Element at index 2: " + myList.get(2));

        myList.remove(1);
        System.out.println("Size after removing element at index 1: " + myList.size());

        myList.clear();
        System.out.println("Size after clearing: " + myList.size());

        for (int i = 0; i < myList.size(); i++) {
            System.err.print(myList.get(i) + "");
        }

    }
}
