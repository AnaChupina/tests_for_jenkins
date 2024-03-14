import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Task 4:
 *
 * 11. Java Stream flatMap() - concatenate 3 arrays into one using flatMap ()
 *         List<Integer> list1 = Arrays.asList(1,2,3);
 *        List<Integer> list2 = Arrays.asList(4,5,6);
 *        List<Integer> list3 = Arrays.asList(7,8,9);
 *
 *
 * And these are also combined into 1 String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
 *
 * 12. Stream.distinct() to remove duplicates - remove duplicates from this array and display.
 * ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
 *
 * 13. (OPTIONAL, NOT MANDATORY) Collectors.toMap() - move the list into Map where the key is an element of the array and the value is the number of times the element occurs in the array
 *  ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
 *
 *
 * Please provide @mkuznietsov (Slack) with your solution.
 */
public class FourthTask {
    @Step
    @SafeVarargs
    public final <T>ArrayList<T> concatenateArraysIntoOne(List<T>... lists){
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    @Step
    public ArrayList<String> concatenateStringArraysIntoOne(String[][] dataArray){
        return concatenateArraysIntoOne(Stream.of(dataArray)
                .map(List::of)
                .toArray(List[]::new));
    }
    @Step
    public ArrayList<Integer> removeDuplicatesFromArrayList (List<Integer> numbersList){
        return numbersList.stream()
                .distinct()
                .collect(Collectors
                .toCollection(ArrayList::new));
    }
    @Step
    public void displayList(List<Integer> numbersList){
        numbersList.forEach(System.out::println);
    }
    @Step
    public Map<Integer, Long> countHowManyTimesEachDigitOccursGroupingBy (ArrayList<Integer> numbersList){
        return numbersList.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }
    @Step
    public Map<Integer, Integer> countHowManyTimesEachDigitOccurs (ArrayList<Integer> numbersList){
        return numbersList.stream()
                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));
    }
    @Step
    public <T, N> void displayMap(Map<T, N> map){
        map.forEach((k,v) -> System.out.println("The number " + k + " occurs " + v + " times"));
    }
}
