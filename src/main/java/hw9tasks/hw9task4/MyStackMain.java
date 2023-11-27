package hw9tasks.hw9task4;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("B");   //бараболя - картопля;
        myStack.push("A");
        myStack.push("R");
        myStack.push("A");
        myStack.push("B");
        myStack.push("O");
        myStack.push("L");
        myStack.push("I");
        myStack.push("A");


        System.out.println("Size: " + myStack.size());

        System.out.println("Peek: " + myStack.peek());

        System.out.println("Pop: " + myStack.pop());
        System.out.println("Size after pop: " + myStack.size());

        myStack.clear();
        System.out.println("Size after clearing: " + myStack.size());
    }
}
