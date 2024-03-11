import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Task 3:
 *
 * 6. a) Display names that start with ‘A’ and have length > 5;
 * b) Sort all names and display them in lower case on the screen
 * List<String> memberNames = new ArrayList<>();
 * memberNames.add("Amitabh");
 * memberNames.add("Shekhar");
 * memberNames.add("Aman");
 * memberNames.add("Rahul");
 * memberNames.add("Shahrukh");
 * memberNames.add("Abibaba");
 * memberNames.add("Salman");
 * memberNames.add("Yana");
 * memberNames.add("Lokesh");
 *
 * 7. Stream.match() - Various matching operations can be used to check whether a given predicate matches the stream elements. Match returns a boolean result.
 * From task 6, take an array and check with allMatch or anyMatch whether the list contains names with the letter ‘S’ (allMatch should display false, anyMatch should display true)
 * From task 6, take an array and check with noneMatch whether the list contains names with the letter ‘H’ (should display true)
 * 8. Stream.count() - The count() is a terminal operation returning the number of elements in the stream as a long value.
 * 9. From task 6 count the number of names starting with “A” - display their number.
 * 10. Stream.findFirst() - take the array from task 6 and print the first name starting with ‘L’
 */
public class ThirdTask {
    public List<String> generateTestData(){
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
        return memberNames;
    }

    public void displayNamesStartedWithAndHaveLengthMoreThan(List<String> list, String startPrefix, int requiredLength){
        list.stream()
                .filter(s -> s.startsWith(startPrefix) &&  s.length() > requiredLength)
                .forEach(System.out::println);
    }
    public void displayStringsSortedAndInLowerCase (List<String> list){
        list.stream().sorted()
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
    public boolean checkIfListContainsNamesWithLetterSUsingAllMatch (List<String> list){
        return list.stream()
                .allMatch(s -> s.contains("S"));
    }
    public boolean checkIfListContainsNamesWithLetterSUsingAnyMatch (List<String> list){
        return list.stream()
                .anyMatch(s -> s.contains("S"));
    }
    public boolean checkIfListContainsNamesWithLetterHUsingNoneMatch (List<String> list){
        return list.stream()
                .noneMatch(s -> s.contains("H"));
    }
    public long countNamesStartedWith(List<String> list, String startPrefix){
        return list.stream()
                .filter(s -> s.startsWith(startPrefix))
                .count();
    }
    public void printFirstNameStartedWith(List<String> list, String startPrefix){
        Optional<String> result = list.stream()
                .filter(s -> s.startsWith(startPrefix))
                .findFirst();
        assertTrue(result.isPresent());
        System.out.println(result.get());
    }

}
