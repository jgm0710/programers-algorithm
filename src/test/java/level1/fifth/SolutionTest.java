package level1.fifth;

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
    void solution(String newName, String result) {
        //given

        //when
        String solutionResult = new Solution().solution(newName);

        //then
        assertEquals(result, solutionResult);

    }

    @Test
    @DisplayName("sample2")
    void sample2() {
        //given


        //when
        String abc = new Solution().solution("");

        //then
        System.out.println("abc = " + abc);

    }


    private static Stream<Arguments> paramsForSolution() {
        return Stream.of(
                Arguments.of("...!@BaT#*..y.abcdefghijklm", "bat.y.abcdefghi"),
                Arguments.of("z-+.^.", "z--"),
                Arguments.of("=.=", "aaa"),
                Arguments.of("123_.def", "123_.def"),
                Arguments.of("abcdefghijklmn.p", "abcdefghijklmn")
        );
    }
}