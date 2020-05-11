package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequence300Test {
    private final LongestIncreasingSubsequence300 java =
            new LongestIncreasingSubsequence300();

    private final LongestIncreasingSubsequenceKotlin300 kotlin =
            new LongestIncreasingSubsequenceKotlin300();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int result) {
        assertEquals(result, java.lengthOfLIS(nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int result) {
        assertEquals(result, kotlin.lengthOfLIS(nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] intArray2 = {10, 9, 2, 5, 3, 4};
        int[] intArray3 = {1, 1};
        return Stream.of(
                Arguments.of(intArray3, 1),
                Arguments.of(intArray2, 3),
                Arguments.of(intArray, 4)
        );
    }
}