package hw13tasks.hw13task1;




import java.io.*;


import static hw13tasks.hw13task1.HttpHendler.deleteUSER;


public class Main {

    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";


    public static void main(String[] args) throws IOException {
        HttpHendler httpHendler = new HttpHendler();

        System.out.println("--------------------------------------GET-----------------------------------------");
        httpHendler.sendGET(USERS_URL);

        System.out.println("-------------------------------------CREATE---------------------------------------");
        String addPesron = httpHendler.createUSER("Taras", "Shevchenko", "Kobzar@ukr.net");
        System.out.println("Created User: " + addPesron);

        System.out.println("-------------------------------------UPDATE---------------------------------------");
        String updatePerson = httpHendler.updateUSER(1, "Grygorii", "Skovoroda", "Skovoroda@gmail.com");
        System.out.println("Update User: " + updatePerson);

        System.out.println("-------------------------------------DELETE---------------------------------------");
        int deleteObject = 5;
        boolean isDelete = deleteUSER(deleteObject);
        System.out.println("Delete User: " + isDelete);

    }
}