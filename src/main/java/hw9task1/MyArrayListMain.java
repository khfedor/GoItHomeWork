package hw9task1;

public class MyArrayListMain {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(32);
        myArrayList.add(21);
        myArrayList.add(45);
        myArrayList.add(67);
        myArrayList.add(87);

        System.out.println(myArrayList.size());
        myArrayList.printArrays();
        myArrayList.remove(3);

        System.out.println(myArrayList.size());
        myArrayList.printArrays();
    }
}

