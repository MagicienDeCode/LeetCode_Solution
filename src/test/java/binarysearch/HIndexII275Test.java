package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HIndexII275Test {
    private final HIndexII275 java =
            new HIndexII275();

    private final HIndexIIKotlin275 kotlin =
            new HIndexIIKotlin275();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int result) {
        assertEquals(result, java.hIndex(nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int result) {
        assertEquals(result, kotlin.hIndex(nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {0, 1, 3, 5, 6};
        int[] intArray2 = {0, 0, 1};
        int[] intArray3 = {1, 1, 3, 3, 100};
        int[] intArray4 = {2, 2, 8, 8, 9};
        int[] intArray5 = {1, 1, 1, 1, 3, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10};
        return Stream.of(
                Arguments.of(intArray5, 6),
                Arguments.of(intArray4, 3),
                Arguments.of(intArray4, 3),
                Arguments.of(intArray3, 3),
                Arguments.of(intArray2, 1),
                Arguments.of(intArray, 3)
        );
    }
}