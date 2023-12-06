package hw13tasks.hw13task2;

import com.google.gson.Gson;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class MatcherCommentsWithPosts {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void MatcherCommentsWithPostsMethod(int userId) {


        try {
            List<String> postsParserListRes = ParserPost.postsParser(userId);
            String post = postsParserListRes.toString();

            List<String> comentsParsList = ParserComents.commentsParser(userId);

            /*System.out.println("------------------POST-----------------");
            for (String posts : postsParserListRes) {
                System.out.println(ANSI_PURPLE + posts + ANSI_RESET + "\n");
            }

            System.out.println("-----------------COMMENT---------------");

            for (String coments : comentsParsList) {
                System.out.println(ANSI_GREEN + coments + ANSI_RESET + "\n");
            }*/

            ResultPostWithComentsPOJO resultPostWithComentsPOJO = new ResultPostWithComentsPOJO(post, comentsParsList);

            Gson gson = new Gson();
            String resultJsonString = gson.toJson(resultPostWithComentsPOJO);

            String nameFile = String.format("user-%d-post-%d-comments.json", userId, userId);

            FileWriter fileWriter = new FileWriter("/Users/khrystynafedor/Documents/HelloWorld1/GoItHomeWork/src/main/java/hw13tasks.hw13task2/" + nameFile, StandardCharsets.UTF_8);
            fileWriter.write(resultJsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MatcherCommentsWithPosts matcherCommentsWithPosts = new MatcherCommentsWithPosts();
        matcherCommentsWithPosts.MatcherCommentsWithPostsMethod(2);
    }
}
