import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTaskTest {
    private final Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
    private final FirstTask firstTask = new FirstTask();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String EXPECTED_OUTPUT_FOR_FIRST_TEST = "1\n2\n3\n4\n5\n6\n7\n8\n9";
    private static final int AMOUNT_OF_NUMBERS_FOR_SECOND_TEST = 20;
    private static final String EXPECTED_OUTPUT_FOR_THIRD_TEST = "2\n4\n6\n8";


//    @Rule
//    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("First Test - testing showStreamOfIntegersInConsole method")
    public void testShowStreamOfIntegersInConsoleDisplaysCorrectly(){
        firstTask.showStreamOfIntegersInConsole(stream);
        //assertEquals(EXPECTED_OUTPUT_FOR_FIRST_TEST, systemOutRule.getLog().trim());
        assertEquals(EXPECTED_OUTPUT_FOR_FIRST_TEST, outContent.toString().trim());
    }
    @Test
    @DisplayName("Second Test - testing createListOfRandomNumbers method")
    public void testCreateListOfRandomNumbersGeneratesListWithExpectedSize(){
        List<Integer> listOfRandomNumbers = firstTask.createListOfRandomNumbers(AMOUNT_OF_NUMBERS_FOR_SECOND_TEST);
        assertEquals(20, listOfRandomNumbers.size());

        firstTask.showStreamOfIntegersInConsole(listOfRandomNumbers.stream());

        //assertEquals(EXPECTED_OUTPUT, outContent.toString().trim());
    }
    @Test
    @DisplayName("Third Test - testing collectOnlyEvenNumbers method")
    public void testCollectOnlyEvenNumbers(){
        List<Integer> inputList = List.of(1,2,3,4,5,6,7,8);
        List<Integer> result = firstTask.collectOnlyEvenNumbers(inputList);

        firstTask.showStreamOfIntegersInConsole(result.stream());

        assertEquals(EXPECTED_OUTPUT_FOR_THIRD_TEST, outContent.toString().trim());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
