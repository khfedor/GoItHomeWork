package HM10TASK1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbersValidator {
    public void phoneNumbers(String url) throws FileNotFoundException {
        FileReader fileReader = new FileReader(url);

       try(BufferedReader bufferedReader = new BufferedReader(fileReader)){
          String temp = null;
          while((temp = bufferedReader.readLine())!=null) {
              String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
              Pattern pattern = Pattern.compile(regex);
              Matcher matcher = pattern.matcher(temp);
              while(matcher.find()) {
                  String isMached = matcher.group();
                  System.out.println(isMached);
              }
          }


       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }


    public static void main(String[] args) throws FileNotFoundException {
        PhoneNumbersValidator pnv = new PhoneNumbersValidator();
        pnv.phoneNumbers("src/HM10TASK1/file.txt");

    }
}
