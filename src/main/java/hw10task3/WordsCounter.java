package hw10task3;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsCounter {
    public void wordsCounterMethod(String url) throws FileNotFoundException {
        Map<String, Integer> wordsNumerator = new HashMap<>();
        FileReader fileReader = new FileReader(url.toLowerCase());
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            StringBuilder stringBuilder = new StringBuilder();
            String tmp = null;
            while ((tmp = bufferedReader.readLine()) != null) {
                stringBuilder.append(tmp);
            }
            String text = stringBuilder.toString();
            Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String match = matcher.group();
                wordsNumerator.put(match, wordsNumerator.getOrDefault(match, 0) + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        wordsNumerator.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer> entry) -> entry.getValue()).reversed())
                .forEach(entry -> System.out.println(String.format("%s %d", entry.getKey(), entry.getValue())));
    }
}
