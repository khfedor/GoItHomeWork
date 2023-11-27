package hw10tasks.hw10task2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserToJsonConvertor {
    public void fileReaderConvertMethodToJson(String url) throws FileNotFoundException{
        List<User> usersCollection = new ArrayList<>();

        FileReader fileReader = new FileReader(url);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String tmp = null;
            while ((tmp = bufferedReader.readLine()) != null) {
                String[] usersInfo = tmp.split(" ");
                if(usersInfo.length == 2) {
                    String name = usersInfo[0];
                    String age = usersInfo[1];
                    User user = new User(name, age);
                    usersCollection.add(user);

                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.writeValue(new File("src/main/java/HM10TASK2/user.json"), usersCollection);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        UserToJsonConvertor userToJsonConvertor = new UserToJsonConvertor();
        userToJsonConvertor.fileReaderConvertMethodToJson("src/main/java/HM10TASK2/file.txt");
    }
}
