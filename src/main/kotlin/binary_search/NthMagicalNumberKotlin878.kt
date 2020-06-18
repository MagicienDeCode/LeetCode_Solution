package binary_search

class NthMagicalNumberKotlin878 {
    fun nthMagicalNumber(N: Int, A: Int, B: Int): Int {
        var left: Long = minOf(A, B).toLong()
        var right: Long = left * N
        val lcmAB = lcm(A, B)
        val modulo = 1e9 + 7
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val countMid = (mid / A - mid / lcmAB + mid / B).toInt()
            when {
                countMid < N -> left = mid
                else -> right = mid
            }
        }
        if ((left / A - left / lcmAB + left / B).toInt() == N) {
            return (left % modulo).toInt()
        }
        return (right % modulo).toInt()
    }

    // LCM, Least Common Multiple 最小公倍数
    private fun lcm(a: Long, b: Long): Long = a.times(b).div(gcd(a, b))

    private fun lcm(a: Int, b: Int): Long = lcm(a.toLong(), b.toLong())

    // GCD, Greatest Common Divisor 最大公约数
    // 辗转相除法
    private fun gcd(valA: Long, valB: Long): Long {
        var a = valA
        var b = valB
        if (a < b) {
            a = a.xor(b)
            b = a.xor(b)
            a = a.xor(b)
        }
        while (a % b != 0.toLong()) {
            val remainder = a % b
            if (b < remainder) {
                a = remainder
            } else {
                a = b
                b = remainder
            }
        }
        return b
    }
}