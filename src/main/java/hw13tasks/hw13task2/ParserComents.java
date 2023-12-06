package hw13tasks.hw13task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserComents {

    public static List<String> commentsParser(int idPost) throws IOException {

        String urlTemplate = "https://jsonplaceholder.typicode.com/posts/%d/comments";

        String finalUrl = String.format(urlTemplate, idPost);

        List<String> postPOJOList = new ArrayList<>();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(finalUrl).openStream()));

        ComentsPOJO[] postPOJOArrays = gson.fromJson(jsonReader, ComentsPOJO[].class);

        for (ComentsPOJO commentsToPost : postPOJOArrays) {
            postPOJOList.add(commentsToPost.body);
        }
        return postPOJOList;
    }

}