package hw10tasks.hw10task3;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
     WordsCounter wordsCounter = new WordsCounter();
     wordsCounter.wordsCounterMethod("src/main/java/HM10TASK3/words.txt");

    }
}
