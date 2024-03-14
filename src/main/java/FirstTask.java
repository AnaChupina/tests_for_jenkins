
import io.qameta.allure.Step;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Task 1:
 *
 * Show in console
 * Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
 * Create a list of random numbers using Stream.generate() , should have 20 items and print in console
 * Collect Stream elements to a List:  Convert list elements to stream, select only even ones, use the collect method to collect them into a List:
 */
public class FirstTask {
    @Step
    public void showStreamOfIntegersInConsole(Stream<Integer> stream ){
        stream.forEach(System.out::println);
    }
    @Step
    public List<Integer> createListOfRandomNumbers(int amountOfNumbers){
        return Stream
                .generate(new Random() :: nextInt)
                .limit(amountOfNumbers)
                .collect(Collectors.toList());
    }
    @Step
    public List<Integer> collectOnlyEvenNumbers (List<Integer> inputList){
        return inputList.stream()
                .filter(x -> (x%2==0))
                .collect(Collectors.toList());
    }

}
