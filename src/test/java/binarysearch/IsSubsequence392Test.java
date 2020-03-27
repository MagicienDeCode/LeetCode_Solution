package binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsSubsequence392Test {
    private final IsSubsequence392 java = new IsSubsequence392();

    private final IsSubsequenceKotlin392 kotlin = new IsSubsequenceKotlin392();

    @ParameterizedTest
    @MethodSource("source")
    void search(String s, String t, boolean result) {
        assertEquals(result, java.isSubsequence(s, t));
    }

    @ParameterizedTest
    @MethodSource("source")
    void searchKotlin(String s, String t, boolean result) {
        assertEquals(result, kotlin.isSubsequence(s, t));
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of("acb", "ahbgdc", false),
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false)
        );
    }
}