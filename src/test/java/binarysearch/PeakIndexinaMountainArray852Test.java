package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeakIndexinaMountainArray852Test {
    private final PeakIndexinaMountainArray852 java = new PeakIndexinaMountainArray852();

    private final PeakIndexinaMountainArrayKotlin852 kotlin =
            new PeakIndexinaMountainArrayKotlin852();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int result) {
        assertEquals(result, java.peakIndexInMountainArray(nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int result) {
        assertEquals(result, kotlin.peakIndexInMountainArray(nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {-1, 0, 3, 5, 9, 8, 7, 6, 1};
        int[] intArray2 = {0, 1, 0};
        return Stream.of(
                Arguments.of(intArray, 4),
                Arguments.of(intArray2, 1)
        );
    }
}
