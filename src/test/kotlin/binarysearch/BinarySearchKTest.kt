package binarysearch

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinarySearchKTest {

    private val binarySearchK = BinarySearchK()

    @ParameterizedTest
    @MethodSource("source")
    fun `binary search`(nums: IntArray, target: Int, result: Int) {
        Assertions.assertEquals(result, binarySearchK.search(nums, target))
    }

    companion object {
        @JvmStatic
        fun source() = listOf(
            Arguments.of(intArrayOf(-1, 0, 3, 5, 9, 12), 9, 4),
            Arguments.of(intArrayOf(-1, 0, 3, 5, 9, 12), 2, -1)
        )
    }
}
