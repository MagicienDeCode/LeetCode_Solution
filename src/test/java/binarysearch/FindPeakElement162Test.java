package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPeakElement162Test {
    private final FindPeakElement162 java =
            new FindPeakElement162();

    private final FindPeakElementKotlin162 kotlin =
            new FindPeakElementKotlin162();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int result) {
        assertEquals(result, java.findPeakElement(nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int result) {
        assertEquals(result, kotlin.findPeakElement(nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {1, 3, 5, 2, 1};
        int[] intArray2 = {1, 3, 1, 3, 1, 3};
        int[] intArray3 = {1, 2, 1, 3, 5, 6, 4};
        int[] intArray4 = {2, 1};
        int[] intArray5 = {1, 2};
        return Stream.of(
                /*
                Arguments.of(intArray2, 3),
                Arguments.of(intArray, 2),
                Arguments.of(intArray3, 5),
                Arguments.of(intArray4, 0),
                */
                Arguments.of(intArray5, 1)
        );
    }
}
