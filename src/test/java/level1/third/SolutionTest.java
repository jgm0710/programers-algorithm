package level1.third;

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
    @DisplayName("solution")
    void solution(int n, String result) {
        //given


        //when
        String solutionResult = new Solution().solution(n);

        //then
        assertEquals(result, solutionResult);

    }

    private static Stream<Arguments> paramsForSolution() {
        return Stream.of(
                Arguments.of(3, "수박수"),
                Arguments.of(4, "수박수박")
        );
    }

}