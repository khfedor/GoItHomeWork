package dimatest;


public interface ExampleInterface {
    static String origin = "Interface";

    void exampleMethod(String first);
}

 class ExampleClass extends ExampleAbstractClass implements ExampleInterface {


    public void exampleMethod(String first) {
    }

    public void exampleMethod(String first, String second) {

    }

    public static void main(String[] args) {



    }
}
