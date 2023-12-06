package hw13tasks.hw13task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserPost {

    public static List<String> postsParser(int idUsers) throws IOException {

        String urlTemplate = "https://jsonplaceholder.typicode.com/users/%d/posts";

        String finalUrl = String.format(urlTemplate, idUsers);

        List<String> postPOJOList = new ArrayList<>();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(finalUrl).openStream()));

        PostPOJO[] postPOJOArrays = gson.fromJson(jsonReader, PostPOJO[].class);

        postPOJOList.clear();

        if (postPOJOArrays.length > 0) {
            PostPOJO lastPost = postPOJOArrays[postPOJOArrays.length - 1];
            postPOJOList.add(lastPost.body);
        }
        return postPOJOList;
    }
}
