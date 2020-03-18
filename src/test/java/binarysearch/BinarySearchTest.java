package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @ParameterizedTest
    @MethodSource("source")
    void binary_search(int[] nums, int target, int result) {
        assertEquals(result, binarySearch.search(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {-1, 0, 3, 5, 9, 12};
        return Stream.of(
                Arguments.of(intArray, 9, 4),
                Arguments.of(intArray, 2, -1)
        );
    }
}
