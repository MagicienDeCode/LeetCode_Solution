package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSizeSubarraySum209Test {
    private final MinimumSizeSubarraySum209 java = new MinimumSizeSubarraySum209();

    private final MinimumSizeSubarraySumKotlin209 kotlin = new MinimumSizeSubarraySumKotlin209();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, int result) {
        assertEquals(result, java.minSubArrayLen(target, nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, int result) {
        assertEquals(result, kotlin.minSubArrayLen(target, nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {2, 3, 1, 2, 4, 3};
        int[] zeroArray = {0};
        int[] test = {1, 2, 3, 4, 5};
        return Stream.of(
                Arguments.of(test, 11, 3),
                Arguments.of(intArray, 9, 3),
                Arguments.of(intArray, 7, 2),
                Arguments.of(zeroArray, 2, 0)
        );
    }
}
