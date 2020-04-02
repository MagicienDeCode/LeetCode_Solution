package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Powxn50Test {

    private final Powxn50 java = new Powxn50();

    private final PowxnKotlin50 kotlin = new PowxnKotlin50();

    @ParameterizedTest
    @MethodSource("source")
    void search(double x, int n, double result) {
        assertEquals(result, java.myPow(x, n));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(double x, int n, double result) {
        assertEquals(result, kotlin.myPow(x, n));
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(2.0, Integer.MIN_VALUE, 0.0),
                Arguments.of(2.0, 10, 1024.0),
                Arguments.of(2.0, -2, 0.25)
        );
    }
}