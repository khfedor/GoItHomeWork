package hw11task.hw11task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise {
    public List<String> oddValues(String url){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(url))){
            List<String> names = bufferedReader.lines().collect(Collectors.toList());
            return IntStream.range(0, names.size()).filter(i->i%2==1).mapToObj(names::get).peek(System.out::println).collect(Collectors.toList());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }




    public static void main(String[] args) {
        Exercise exercise = new Exercise();
        exercise.oddValues("src/main/java/hw11.hw11tasks.hw11task1/filenames.txt");
    }
}


