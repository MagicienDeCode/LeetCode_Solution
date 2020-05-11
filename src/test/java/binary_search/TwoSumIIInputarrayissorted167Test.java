package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TwoSumIIInputarrayissorted167Test {
    private final TwoSumIIInputarrayissorted167 java = new TwoSumIIInputarrayissorted167();

    private final TwoSumIIInputarrayissortedKotlin167 kotlin
            = new TwoSumIIInputarrayissortedKotlin167();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, int[] result) {
        // assertEquals(result, java.twoSum(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, int[] result) {
        // assertEquals(result, kotlin.twoSum(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {2, 7, 9, 11};
        int[] result1 = {1, 2};
        int[] result2 = {3, 4};
        int[] result3 = {1, 3};
        int[] aimArray = {2, 3, 4};
        return Stream.of(
                Arguments.of(intArray, 9, result1),
                Arguments.of(intArray, 20, result2),
                Arguments.of(aimArray, 6, result3)
        );
    }
}
