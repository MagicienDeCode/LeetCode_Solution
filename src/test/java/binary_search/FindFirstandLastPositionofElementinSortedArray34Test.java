package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindFirstandLastPositionofElementinSortedArray34Test {
    private final FindFirstandLastPositionofElementinSortedArray34 java
            = new FindFirstandLastPositionofElementinSortedArray34();

    private final FindFirstandLastPositionofElementinSortedArrayKotlin34 kotlin
            = new FindFirstandLastPositionofElementinSortedArrayKotlin34();

    @ParameterizedTest
    @MethodSource("source")
    void searchRange(int[] nums, int target, int[] result) {
        // assertEquals(result, java.searchRange(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchRangeKotlin(int[] nums, int target, int[] result) {
        // assertEquals(result, kotlin.searchRange(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {5, 7, 7, 8, 8, 10};
        int[] result1 = {3, 4};
        int[] result2 = {-1, -1};
        return Stream.of(
                Arguments.of(intArray, 8, result1),
                Arguments.of(intArray, 6, result2)
        );
    }
}
