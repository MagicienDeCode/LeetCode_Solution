package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindtheSmallestDivisorGivenaThreshold1283Test {
    private final FindtheSmallestDivisorGivenaThreshold1283 java =
            new FindtheSmallestDivisorGivenaThreshold1283();

    private final FindtheSmallestDivisorGivenaThresholdKotlin1283 kotlin =
            new FindtheSmallestDivisorGivenaThresholdKotlin1283();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, int result) {
        assertEquals(result, java.smallestDivisor(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, int result) {
        assertEquals(result, kotlin.smallestDivisor(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {1, 2, 5, 9};
        int[] intArray2 = {2, 3, 5, 7, 11};
        int[] intArray3 = {19};
        return Stream.of(
                Arguments.of(intArray, 6, 5),
                Arguments.of(intArray2, 11, 3),
                Arguments.of(intArray3, 5, 4)
        );
    }
}