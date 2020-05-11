package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertPosition35Test {

    private final SearchInsertPosition35 java = new SearchInsertPosition35();

    private final SearchInsertPositionKotlin35 kotlin = new SearchInsertPositionKotlin35();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, int result) {
        assertEquals(result, java.searchInsert(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, int result) {
        assertEquals(result, kotlin.searchInsert(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {-1, 0, 3, 5, 9, 12};
        //                0   1  2  3  4   5
        return Stream.of(
                Arguments.of(intArray, 9, 4),
                Arguments.of(intArray, 2, 2),
                Arguments.of(intArray, 13, 6),
                Arguments.of(intArray, -3, 0)
        );
    }
}
