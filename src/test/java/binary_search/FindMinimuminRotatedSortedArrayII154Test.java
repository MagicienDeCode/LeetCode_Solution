package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinimuminRotatedSortedArrayII154Test {
    private final FindMinimuminRotatedSortedArrayII154 java =
            new FindMinimuminRotatedSortedArrayII154();

    private final FindMinimuminRotatedSortedArrayIIKotlin154 kotlin =
            new FindMinimuminRotatedSortedArrayIIKotlin154();

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
        int[] intArray = {1, 3, 5};
        int[] intArray2 = {1, 1, 1, 1, 1};
        int[] intArray3 = {2, 2, 2, 0, 1};
        return Stream.of(
                Arguments.of(intArray2, 1),
                Arguments.of(intArray, 1),
                Arguments.of(intArray3, 0)
        );
    }
}
