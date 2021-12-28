package level1.sixth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SixthSolutionTest {

    @ParameterizedTest
    @MethodSource("paramsForSolution")
    @DisplayName("solution")
    void solution(String s, int result) {
        //given

        //when
        int solution = new SixthSolution().solution(s);

        //then
        assertEquals(result, solution);

    }

    private static Stream<Arguments> paramsForSolution() {
        return Stream.of(
                Arguments.of("one4seveneight", 1478),
                Arguments.of("23four5six7", 234567),
                Arguments.of("2three45sixseven", 234567),
                Arguments.of("123", 123)
        );
    }
}