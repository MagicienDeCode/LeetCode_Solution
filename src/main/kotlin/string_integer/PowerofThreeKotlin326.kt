package string_integer

import kotlin.math.log10

class PowerofThreeKotlin326 {
    fun isPowerOfThree(n: Int): Boolean {
        return (log10(n.toDouble()) / log10(3.toDouble())) % 1 == 0.0
    }
    /*
    fun isPowerOfThree(n: Int): Boolean {
        var current = n
        if (current < 1) {
            return false
        }
        while (current % 3 == 0) {
            current /= 3
        }
        return current == 1
    }
     */
}