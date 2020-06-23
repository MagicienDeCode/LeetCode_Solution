package binary_search

class ThreeEqualPartsKotlin927 {
    fun threeEqualParts(A: IntArray): IntArray {
        val countOne = A.sum()
        if (countOne == 0) {
            return intArrayOf(0, A.size - 1)
        }
        if (countOne % 3 != 0) {
            return intArrayOf(-1, -1)
        }
        val numberOne = countOne / 3
        var first = 0
        var second: Int
        var third: Int
        var index = 0
        while (A[index] == 0) {
            ++first
            ++index
        }
        var countOfOne = 0
        while (countOfOne != numberOne) {
            if (A[index] == 1) {
                ++countOfOne
            }
            ++index
        }
        while (A[index] == 0) {
            ++index
        }
        second = index
        countOfOne = 0
        while (countOfOne != numberOne) {
            if (A[index] == 1) {
                ++countOfOne
            }
            ++index
        }
        while (A[index] == 0) {
            ++index
        }
        third = index
        while (third < A.size && A[first] == A[second] && A[first] == A[third]) {
            ++third
            ++second
            ++first
        }
        return if (third == A.size) {
            intArrayOf(first - 1, second)
        } else {
            intArrayOf(-1, -1)
        }
    }
}

fun main() {
    val solution = ThreeEqualPartsKotlin927()
    solution.threeEqualParts(intArrayOf(0, 1, 0, 1, 1)).forEach(::print)
    println()
    solution.threeEqualParts(intArrayOf(1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1)).forEach(::print)
    println()
    solution.threeEqualParts(intArrayOf(1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0)).forEach(::print)
    println()
    solution.threeEqualParts(intArrayOf(1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0)).forEach(::print)
    println()
    solution.threeEqualParts(intArrayOf(1, 0, 1, 0, 1)).forEach(::print)
    println()
    solution.threeEqualParts(intArrayOf(1, 1, 0, 1, 1)).forEach(::print)
    println()
}