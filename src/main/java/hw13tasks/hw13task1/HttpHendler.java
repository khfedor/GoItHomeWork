package hw13tasks.hw13task1;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpHendler {

    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

    //  A method to get data from the API and get the connection code.
    static void sendGET(String USERS_URL) throws IOException {
        URL url = new URL(USERS_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }


    // Створення Об'єкту
    public static String createUSER(String name, String username, String email) throws IOException {
        URL url = new URL(USERS_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        JSONObject newUserJson = new JSONObject();
        newUserJson.put("name", name);
        newUserJson.put("username", username);
        newUserJson.put("email", email);

        String newUser = newUserJson.toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = newUser.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }


    // Updating the Object
    public static String updateUSER(int id, String name, String username, String email) throws IOException {
        URL url = new URL(USERS_URL + "/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        JSONObject updateUserJson = new JSONObject();
        updateUserJson.put("name", name);
        updateUserJson.put("username", username);
        updateUserJson.put("email", email);

        String newUser = updateUserJson.toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = newUser.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }


    // Object deletion
    public static boolean deleteUSER(int id) throws IOException {
        URL url = new URL(USERS_URL + "/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        if (connection.equals("true"))
            System.out.println("Object #" + id + " deleted successfully");
        return connection.getResponseCode() / 100 == 2;
    }
}
