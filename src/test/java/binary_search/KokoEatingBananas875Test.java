package binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KokoEatingBananas875Test {
    private final KokoEatingBananas875 java = new KokoEatingBananas875();

    private final KokoEatingBananasKotlin875 kotlin = new KokoEatingBananasKotlin875();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[] nums, int target, int result) {
        assertEquals(result, java.minEatingSpeed(nums, target));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[] nums, int target, int result) {
        assertEquals(result, kotlin.minEatingSpeed(nums, target));
    }

    private static Stream<Arguments> source() {
        int[] intArray = {3, 6, 7, 11};
        int[] intArray2 = {30, 11, 23, 4, 20};
        int[] intArray3 = {30, 11, 23, 4, 20};
        int[] intArray4 = {2, 2};
        return Stream.of(
                Arguments.of(intArray4, 2, 2),
                Arguments.of(intArray, 8, 4),
                Arguments.of(intArray2, 5, 30),
                Arguments.of(intArray3, 6, 23)
        );
    }
}