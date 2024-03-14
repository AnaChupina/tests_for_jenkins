import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Task 5:
 *
 *  14. Write to a new list only letters that occur in the values of this map
 * Map<String, List<String>> people = new HashMap<>();
 *    people.put("John", Arrays.asList("555-1123","s", "555-3389", "a"));
 *    people.put("Mary", Arrays.asList("555-2243","z", "555-5264"));
 *    people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));
 */
public class FifthTask {
    @Step
    public Map<String, List<String>> generateTestData(){
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123","s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243","z", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));

        return people;
    }
    @Step
    public List<String> getLettersFromValuesOfMap(Map<String, List<String>> inputMap){
        return inputMap.values().stream().flatMap(List::stream)
                .filter(s -> s.matches("[a-zA-Z]"))
                .collect(Collectors.toList());
    }
}
