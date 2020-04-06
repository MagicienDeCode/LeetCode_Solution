package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinimuminRotatedSortedArray153Test {

    private final FindMinimuminRotatedSortedArray153 java =
            new FindMinimuminRotatedSortedArray153();

    private final FindMinimuminRotatedSortedArrayKotlin153 kotlin =
            new FindMinimuminRotatedSortedArrayKotlin153();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int result) {
        assertEquals(result, java.findMin(nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int result) {
        assertEquals(result, kotlin.findMin(nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {4, 5, 6, 7, 0, 1, 2};
        int[] intArray2 = {3, 4, 5, 1, 2};
        int[] intArray3 = {0, 1, 2, 3, 4, 5};
        return Stream.of(
                Arguments.of(intArray2, 1),
                Arguments.of(intArray, 0),
                Arguments.of(intArray3, 0)
        );
    }
}
