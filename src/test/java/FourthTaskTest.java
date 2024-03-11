import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourthTaskTest {
    private final FourthTask fourthTask = new FourthTask();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final List<Integer> list1 = Arrays.asList(1,2,3);
    private final List<Integer> list2 = Arrays.asList(4,5,6);
    private final List<Integer> list3 = Arrays.asList(7,8,9);
    private final ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
    private static final ArrayList<Integer> EXPECTED_RESULT_LIST_FOR_FIRST_TEST =  new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    private static final ArrayList<String> EXPECTED_RESULT_LIST_FOR_SECOND_TEST =  new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
    String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
    private static final String EXPECTED_RESULT_FOR_THIRD_TEST = "1\n2\n3\n4\n5\n6\n7";
    private static final String EXPECTED_RESULT_FOR_FOURTH_TEST =
            "The number 1 occurs 2 times\n" +
            "The number 2 occurs 1 times\n" +
            "The number 3 occurs 3 times\n" +
            "The number 4 occurs 1 times\n" +
            "The number 5 occurs 1 times\n" +
            "The number 6 occurs 3 times\n" +
            "The number 7 occurs 1 times";

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    @DisplayName("11. First test - testing concatenateFewArraysIntoOne method")
    public void testConcatenateFewArraysIntoOne(){
        ArrayList<Integer> resultList = fourthTask.concatenateArraysIntoOne(list1, list2, list3);

        assertEquals(EXPECTED_RESULT_LIST_FOR_FIRST_TEST, resultList);
    }
    @Test
    @DisplayName("11. Second test - testing concatenateStringArraysIntoOne method")
    public void testConcatenateStringArraysIntoOne(){
        ArrayList<String> resultList = fourthTask.concatenateStringArraysIntoOne(dataArray);

        assertEquals(EXPECTED_RESULT_LIST_FOR_SECOND_TEST, resultList);
    }

    @Test
    @DisplayName("12. Third test - testing removeDuplicatesFromArrayList method")
    public void testRemoveDuplicatesFromArrayListAndDisplay(){
        ArrayList<Integer> arrayWithoutDuplicates = fourthTask.removeDuplicatesFromArrayList(numbersList);
        fourthTask.displayList(arrayWithoutDuplicates);

        assertEquals(EXPECTED_RESULT_FOR_THIRD_TEST, outContent.toString().trim());
    }
    @Test
    @DisplayName("13. Fourth test - testing countHowManyTimesEachDigitOccurs method")
    public void testCountHowManyTimesEachDigitOccurs(){
        Map<Integer, Integer> resultMap = fourthTask.countHowManyTimesEachDigitOccurs(numbersList);
        fourthTask.displayMap(resultMap);

        assertEquals(EXPECTED_RESULT_FOR_FOURTH_TEST, outContent.toString().trim());
    }
    @Test
    @DisplayName("13. Fifth test - testing countHowManyTimesEachDigitOccursGroupingBy method")
    public void testCountHowManyTimesEachDigitOccursGroupingBy(){
        Map<Integer, Long> resultMap = fourthTask.countHowManyTimesEachDigitOccursGroupingBy(numbersList);
        fourthTask.displayMap(resultMap);

        assertEquals(EXPECTED_RESULT_FOR_FOURTH_TEST, outContent.toString().trim());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
