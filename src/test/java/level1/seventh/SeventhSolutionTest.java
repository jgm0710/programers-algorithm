package level1.seventh;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SeventhSolutionTest {

    @ParameterizedTest
    @MethodSource("paramsForSolution")
    @DisplayName("solution")
    void solution(int[] numbers, String hand, String result) {
        //given

        //when
        String solutionResult = new SeventhSolution().solution(numbers, hand);

        //then
        assertEquals(result, solutionResult);

    }

    private static Stream<Arguments> paramsForSolution() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right", "LRLLLRLLRRL"),
                Arguments.of(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left", "LRLLRRLLLRR"),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right", "LLRLLRLLRL")
        );
    }

}