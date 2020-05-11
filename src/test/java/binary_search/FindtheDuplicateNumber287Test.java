package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindtheDuplicateNumber287Test {
    private final FindtheDuplicateNumber287 java =
            new FindtheDuplicateNumber287();

    private final FindtheDuplicateNumberKotlin287 kotlin =
            new FindtheDuplicateNumberKotlin287();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int result) {
        assertEquals(result, java.findDuplicate(nums));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int result) {
        assertEquals(result, kotlin.findDuplicate(nums));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {1, 3, 4, 2, 2};
        int[] intArray2 = {3, 1, 3, 4, 2};
        int[] intArray3 = {2, 2, 2, 2, 2};
        return Stream.of(
                Arguments.of(intArray3, 2),
                Arguments.of(intArray, 2),
                Arguments.of(intArray2, 3)
        );

    }
}
