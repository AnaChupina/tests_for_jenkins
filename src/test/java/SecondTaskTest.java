import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondTaskTest {
    SecondTask secondTask = new SecondTask();
    List<Integer> listOfIntegers = secondTask.generateIntegerTestData();
    List<String> listOfStrings = secondTask.generateStringTestData();
    private static final String EXPECTED_RESULT_FOR_FIRST_TEST = "[2, 4, 6, 8]";
    private static final String EXPECTED_RESULT_FOR_SECOND_TEST = "[C2, C1]";

    @Test
    public void testCollectOnlyEvenNumbersInArrayOfInt(){
        int [] actualResult = secondTask.collectOnlyEvenNumbersInArrayOfInt(listOfIntegers);
        assertEquals(EXPECTED_RESULT_FOR_FIRST_TEST, Arrays.toString(actualResult));
    }
    @Test
    public void testFilterStringsConvertToUppercaseSortInDescendingOrder(){
        List<String> actualResult = secondTask.filterStringsConvertToUppercaseSortInDescendingOrder(listOfStrings);
        assertEquals(EXPECTED_RESULT_FOR_SECOND_TEST, actualResult.toString());
    }

}
