package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSmallestElementinaSortedMatrix378Test {
    private final KthSmallestElementinaSortedMatrix378 java =
            new KthSmallestElementinaSortedMatrix378();

    private final KthSmallestElementinaSortedMatrixKotlin378 kotlin =
            new KthSmallestElementinaSortedMatrixKotlin378();

    @ParameterizedTest
    @MethodSource("source")
    void search(int[][] nums, int k, int result) {
        assertEquals(result, java.kthSmallest(nums, k));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(int[][] nums, int k, int result) {
        assertEquals(result, kotlin.kthSmallest(nums, k));
    }

    private static Stream<Arguments> source() {
        int[][] intMatrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] intMatrix2 = {{1, 2}, {1, 3}};
        return Stream.of(
                Arguments.of(intMatrix, 8, 13),
                Arguments.of(intMatrix2, 1, 1),
                Arguments.of(intMatrix2, 3, 2)
        );
    }
}