import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThirdTaskTest {
    ThirdTask thirdTask = new ThirdTask();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final List<String> memberNames = thirdTask.generateTestData();
    private static final String START_PREFIX = "A";
    private static final int REQUIRED_LENGTH = 5;
    private static final String EXPECTED_OUTPUT_FOR_FIRST_TEST = "Amitabh\nAbibaba";
    private static final String EXPECTED_OUTPUT_FOR_SECOND_TEST = "abibaba\naman\namitabh\nlokesh\nrahul\nsalman\nshahrukh\nshekhar\nyana";
    private static final long EXPECTED_RESULT_SIXTH_TEST = 3;
    private static final String EXPECTED_RESULT_SEVENTH_TEST = "Lokesh";
    private static final String START_PREFIX_FOR_SEVENTH_TEST = "L";

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("6. a) First Test - testing displayNamesStartedWithAndHaveLengthMoreThan method")
    public void testDisplayNamesStartedWithAndHaveLengthMoreThat(){
        thirdTask.displayNamesStartedWithAndHaveLengthMoreThan(memberNames, START_PREFIX, REQUIRED_LENGTH);
        assertEquals(EXPECTED_OUTPUT_FOR_FIRST_TEST, outContent.toString().trim());
    }
    @Test
    @DisplayName("6. b) Second Test - testing DisplayStringsSortedAndInLowerCase method")
    public void testDisplayStringsSortedAndInLowerCase(){
        thirdTask.displayStringsSortedAndInLowerCase(memberNames);
        assertEquals(EXPECTED_OUTPUT_FOR_SECOND_TEST, outContent.toString().trim());
    }
    @Test
    @DisplayName("7. Third Test - testing checkIfListContainsNamesWithLetterSUsingAllMatch method")
    public void testIfListContainsNamesWithLetterSUsingAllMatch(){
        boolean actualResult = thirdTask.checkIfListContainsNamesWithLetterSUsingAllMatch(memberNames);
        assertFalse(actualResult);
    }
    @Test
    @DisplayName("7. Fourth Test - testing checkIfListContainsNamesWithLetterSUsingAnyMatch method")
    public void testIfListContainsNamesWithLetterSUsingAnyMatch(){
        boolean actualResult = thirdTask.checkIfListContainsNamesWithLetterSUsingAnyMatch(memberNames);
        assertTrue(actualResult);
    }
    @Test
    @DisplayName("7. Fifth Test - testing checkIfListContainsNamesWithLetterHUsingNoneMatch method")
    public void testIfListContainsNamesWithLetterHUsingNoneMatch(){
        boolean actualResult = thirdTask.checkIfListContainsNamesWithLetterHUsingNoneMatch(memberNames);
        assertTrue(actualResult);
    }
    @Test
    @DisplayName("9. Sixth Test - testing countNamesStartedWith method")
    public void testCountNamesStartedWithDisplaysCorrectResult(){
        long actualResult = thirdTask.countNamesStartedWith(memberNames, START_PREFIX);
        assertEquals(EXPECTED_RESULT_SIXTH_TEST, actualResult);
    }
    @Test
    @DisplayName("10. Seventh Test - testing printFirstNameStartedWith method")
    public void testPrintFirstNameStartedWith(){
        thirdTask.printFirstNameStartedWith(memberNames, START_PREFIX_FOR_SEVENTH_TEST);
        assertEquals(EXPECTED_RESULT_SEVENTH_TEST, outContent.toString().trim());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
