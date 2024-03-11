import java.util.*;
import java.util.stream.Collectors;

/**
 * Task 2:
 *
 * List<Integer> list = new ArrayList<Integer>();
 * for(int i = 1, i < 10; i++){
 * list.add(i)
 * }
 *
 * Repeat the same as in task 3 but collect all the elements in Array [];
 * filter values, keep those that start with "c", convert all values, convert to uppercase, sort in Descending order
 *  List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
 */
public class SecondTask {

    public int[] collectOnlyEvenNumbersInArrayOfInt (List<Integer> inputList){
        return inputList.stream()
                .filter(x -> (x % 2 == 0))
                .mapToInt(x -> x)
                .toArray();
    }

    public List<Integer> generateIntegerTestData(){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            list.add(i);
        }
        return list;
    }
    public List<String> generateStringTestData(){
        return Arrays.asList("a1", "a2", "b1", "c2", "c1");
    }

    public List<String> filterStringsConvertToUppercaseSortInDescendingOrder(List<String> list){
        return list.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted(Collections. reverseOrder())
                .collect(Collectors.toList());
    }

}
