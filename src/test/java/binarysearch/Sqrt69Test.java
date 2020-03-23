package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Sqrt69Test {
    private final Sqrt69 java = new Sqrt69();

    private final SqrtKotlin69 kotlin = new SqrtKotlin69();

    @ParameterizedTest
    @MethodSource("source")
    void search(int target, int result) {
        assertEquals(result, java.mySqrt(target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int target, int result) {
        assertEquals(result, kotlin.mySqrt(target));
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(8, 2),
                Arguments.of(Integer.MAX_VALUE, 46340)
        );
    }
}
