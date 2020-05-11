package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumofMutatedArrayClosesttoTarget1300Test {
    private final SumofMutatedArrayClosesttoTarget1300 java
            = new SumofMutatedArrayClosesttoTarget1300();

    private final SumofMutatedArrayClosesttoTargetKotlin1300 kotlin
            = new SumofMutatedArrayClosesttoTargetKotlin1300();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, int result) {
        assertEquals(result, java.findBestValue(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, int result) {
        assertEquals(result, kotlin.findBestValue(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {4, 3, 9};
        int[] intArray2 = {2, 3, 5};
        int[] intArray3 = {60864, 25176, 27249, 21296, 20204};
        return Stream.of(
                // Arguments.of(intArray2, 12, 5),
                // Arguments.of(intArray2, 11, 5),
                Arguments.of(intArray, 10, 3),
                Arguments.of(intArray2, 10, 5),
                Arguments.of(intArray3, 56803, 11361)
        );
    }
}