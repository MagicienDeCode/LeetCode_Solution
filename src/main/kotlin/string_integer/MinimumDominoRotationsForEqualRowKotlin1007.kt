package string_integer

class MinimumDominoRotationsForEqualRowKotlin1007 {
    fun minDominoRotations(a: IntArray, b: IntArray): Int {
        var min = Int.MAX_VALUE
        for (i in 1..6) {
            val ab = domino(a, b, i)
            if (ab != -1) {
                min = Math.min(min, ab)
            }
            val ba = domino(b, a, i)
            if (ba != -1) {
                min = Math.min(min, ba)
            }
        }
        return if (min == Int.MAX_VALUE) -1 else min
    }

    private fun domino(a: IntArray, b: IntArray, target: Int): Int {
        var count = 0
        var result = true
        for (i in a.indices) {
            if (a[i] != target) {
                if (b[i] == target) {
                    count++
                } else {
                    result = false
                    break
                }
            }
        }
        return if (result) count else -1
    }
}