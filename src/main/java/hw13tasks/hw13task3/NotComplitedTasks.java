package hw13tasks.hw13task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotComplitedTasks {
//   "userId": 1,
//            "id": 1,
//            "title": "delectus aut autem",
//            "completed": false

    private int userId;
    private int id;
    private String title;
    private String completed;

    public NotComplitedTasks(int userId, int id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return
                "userId - " + userId + ", id - " + id + ", title - " + title + ", completed - " + completed;
    }

    public static List<NotComplitedTasks> notComplited(String url) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()))) {
            NotComplitedTasks[] notComplitedTasks = gson.fromJson(jsonReader, NotComplitedTasks[].class);
            return Arrays.stream(notComplitedTasks).filter(todolist -> "false".equals(todolist.getCompleted())).collect(Collectors.toList());


        }

    }

    public static void main(String[] args) throws IOException {
        try {
            List<NotComplitedTasks> notComplitedTasksList = notComplited("https://jsonplaceholder.typicode.com/users/1/todos");
            notComplitedTasksList.forEach(System.out::println);
        } catch (IOException exeption) {
            exeption.printStackTrace();
        }
    }
}
