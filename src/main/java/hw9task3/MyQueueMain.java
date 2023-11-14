package hw9task3;

public class MyQueueMain {
    public static void main(String[] args) {


        MyQueue myQueue = new MyQueue();
        myQueue.add("M"); //манатки(лахи) - одяг;
        myQueue.add("A");
        myQueue.add("N");
        myQueue.add("A");
        myQueue.add("T");
        myQueue.add("K");
        myQueue.add("Y");

        try {
            while (!myQueue.isEmpty()) {
                System.out.print(myQueue.poll());
            }
            System.out.println();
            System.out.println("Size: " + myQueue.size());

            System.out.println("Peek: " + myQueue.peek());

            System.out.println("Poll: " + myQueue.poll());
            System.out.println("Size after poll: " + myQueue.size());

            myQueue.clear();
            System.out.println("Size after clearing: " + myQueue.size());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
