package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchinRotatedSortedArrayII81Test {

    private final SearchinRotatedSortedArrayII81 java = new SearchinRotatedSortedArrayII81();

    private final SearchinRotatedSortedArrayIIKotlin81 kotlin =
            new SearchinRotatedSortedArrayIIKotlin81();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, boolean result) {
        assertEquals(result, java.search(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, boolean result) {
        assertEquals(result, kotlin.search(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {1, 1, 3, 1};
        int[] intArray2 = {2, 5, 6, 0, 0, 1, 2};
        int[] intArray3 = {1, 3, 1, 1, 1};
        return Stream.of(
                Arguments.of(intArray2, 0, true),
                Arguments.of(intArray2, 3, false),
                Arguments.of(intArray, 3, true),
                Arguments.of(intArray3, 3, true)
        );
    }
}
