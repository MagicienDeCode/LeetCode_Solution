package binarysearch

class UglyNumberIIIKotlin1201 {
    fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
        val lcmab: Long = lcm(a, b)
        val lcmac: Long = lcm(a, c)
        val lcmbc: Long = lcm(c, b)
        val lcmabc: Long = lcm(lcmab, c.toLong())
        val minOfabc = minOf(minOf(a, b), c)
        var left = minOfabc
        var right = minOfabc * n
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val midN = mid / a - mid / lcmab + mid / b - mid / lcmbc + mid / c - mid / lcmac + mid / lcmabc
            when {
                midN == n.toLong() -> {
                    when {
                        mid % a == 0 ||
                                mid % b == 0 ||
                                mid % c == 0
                        -> return mid
                        else -> right = mid
                    }
                }
                midN < n -> left = mid
                else -> right = mid
            }
        }
        return when (n.toLong()) {
            left / a - left / lcmab + left / b - left / lcmbc + left / c - left / lcmac + left / lcmabc -> left
            else -> right
        }
    }
    /*
    // GCD, Greatest Common Divisor 最大公约数
    // 更相减损法
    private fun gcd(valA: Long, valB: Long): Long {
        var a = valA
        var b = valB
        if (a < b) {
            a = a.xor(b)
            b = a.xor(b)
            a = a.xor(b)
        }
        while (a != b) {
            val remainder = a - b
            if (b < remainder) {
                a = remainder
            } else {
                a = b
                b = remainder
            }
        }
        return b
    }
     */

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

fun main() {
    val solution = UglyNumberIIIKotlin1201()
    // println(solution.gcd(319, 377)) // 29
    // println(solution.nthUglyNumber(3, 2, 3, 5))  // 4
    // 1999999984
    println(solution.nthUglyNumber(1000000000, 2, 217983653, 336916467))
}