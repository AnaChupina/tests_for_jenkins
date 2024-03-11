import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FifthTaskTest {
    private final FifthTask fifthTask = new FifthTask();
    private final Map<String, List<String>> testMap = fifthTask.generateTestData();
    private final List<String> EXPECTED_RESULT_LIST = new ArrayList<>(Arrays.asList("s", "a", "z", "d"));

    @Test
    public void testGetLettersFromValuesOfMap(){
        List<String> actualResultList = fifthTask.getLettersFromValuesOfMap(testMap);
        assertThat(actualResultList).hasSameElementsAs(EXPECTED_RESULT_LIST);
    }
}
