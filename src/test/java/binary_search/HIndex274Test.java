package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HIndex274Test {
    private final HIndex274 java =
            new HIndex274();

    private final HIndexKotlin274 kotlin =
            new HIndexKotlin274();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int result) {
        assertEquals(result, java.hIndex(nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int result) {
        assertEquals(result, kotlin.hIndex(nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {3, 0, 6, 1, 5};
        return Stream.of(
                Arguments.of(intArray, 3)
        );
    }
}
