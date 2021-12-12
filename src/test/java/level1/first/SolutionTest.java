package level1.first;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("paramsForSolution")
    @DisplayName("sample")
    void sample(String[] participant, String[] completion, String result) {
        //given

        //when
        String solutionResult = new Solution().solution(participant, completion);

        //then
        assertEquals(result, solutionResult);

    }

    private static Stream<Arguments> paramsForSolution() {
        return Stream.of(
                Arguments.of(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}, "leo"),
                Arguments.of(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}, "vinko"),
                Arguments.of(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}, "mislav")
        );
    }

}