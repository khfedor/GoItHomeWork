package hw11task.hw11task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
        public List<String> sortedNames(String url) throws Exception {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(url))) {
                return bufferedReader.lines().map(String::toUpperCase).sorted(Collator.getInstance().reversed()).peek(System.out::println).collect(Collectors.toList());

            }
            catch(Exception e){
                throw new Exception(e);
            }
        }




    public static void main(String[] args) throws Exception {
        Exercise2 exercise2 = new Exercise2();
        exercise2.sortedNames("src/main/java/hw11.hw11tasks.hw11task1/filenames.txt");
    }
}
