package hw11.hw11tasks.hw11task3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedArrayWithStream {

    public List<Integer> SortedArraysWithStreamMethod(String[] arr) {
        try {
            String arrToString = String.join(",", arr);
            List<Integer> integerList = Arrays.stream(arrToString.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
            Collections.sort(integerList);
            return integerList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        String[] arr = {"1, 4, 5", "2, 0", "3"};
        String[] test = {"5, 9, 3", "12, 11", "7, 1, 8", "4,6", "2", "10"};
        SortedArrayWithStream arraysToSortFromStream = new SortedArrayWithStream();
        System.out.println(arraysToSortFromStream.SortedArraysWithStreamMethod(arr));
        System.out.println(arraysToSortFromStream.SortedArraysWithStreamMethod(test));
    }
}


