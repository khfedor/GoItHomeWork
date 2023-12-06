package hw13tasks.hw13task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private int userId;
    private int id;
    private String title;
    private String completed;

    public Task3(int userId, int id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public String getCompleted() {
        return completed;
    }


    @Override
    public String toString() {
        return "UserId: " + userId + " ID: " + id + " Title: " + title + " Completed: " + ANSI_RED + completed + ANSI_RESET;
    }

    public static List<Task3> todosParser(String url) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()))) {
            Task3[] task3s = gson.fromJson(jsonReader, Task3[].class);

            return Arrays.stream(task3s)
                    .filter(todo -> "false".equals(todo.getCompleted()))
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            List<Task3> incompleteTodos = todosParser("https://jsonplaceholder.typicode.com/users/1/todos");
            incompleteTodos.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
