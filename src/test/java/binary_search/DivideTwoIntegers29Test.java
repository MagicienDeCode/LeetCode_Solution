package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideTwoIntegers29Test {

    private final DivideTwoIntegers29 java = new DivideTwoIntegers29();

    private final DivideTwoIntegersKotlin29 kotlin = new DivideTwoIntegersKotlin29();

    @ParameterizedTest
    @MethodSource("source")
    void search(int dividend, int divisor, int result) {
        assertEquals(result, java.divide(dividend, divisor));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int dividend, int divisor, int result) {
        assertEquals(result, kotlin.divide(dividend, divisor));
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(Integer.MIN_VALUE, 2, Integer.MIN_VALUE / 2),
                Arguments.of(23, 3, 7),
                Arguments.of(Integer.MAX_VALUE, 2, Integer.MAX_VALUE / 2),
                Arguments.of(Integer.MAX_VALUE, 1, Integer.MAX_VALUE),
                Arguments.of(10, 3, 3),
                Arguments.of(7, -3, -2),
                Arguments.of(10, 2, 5),
                Arguments.of(Integer.MIN_VALUE, -1, Integer.MAX_VALUE)

        );
    }
}