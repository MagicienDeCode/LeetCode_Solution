package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapacityToShipPackagesWithinDDays1011Test {
    private final CapacityToShipPackagesWithinDDays1011 java
            = new CapacityToShipPackagesWithinDDays1011();

    private final CapacityToShipPackagesWithinDDaysKotlin1011 kotlin
            = new CapacityToShipPackagesWithinDDaysKotlin1011();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, int result) {
        assertEquals(result, java.shipWithinDays(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, int result) {
        assertEquals(result, kotlin.shipWithinDays(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] intArray2 = {3, 2, 2, 4, 1, 4};
        int[] intArray3 = {1, 2, 3, 1, 1};
        int[] intArray4 = new int[502];
        Arrays.fill(intArray4, 500);
        return Stream.of(
                Arguments.of(intArray4, 1, 502 * 500),
                Arguments.of(intArray2, 3, 6),
                Arguments.of(intArray, 5, 15),
                Arguments.of(intArray3, 4, 3)
        );
    }
}