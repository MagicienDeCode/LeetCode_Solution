package string_integer

class LongestPalindromeKotlin409 {
    fun longestPalindrome(s: String): Int {
        val count = IntArray(128)
        s.toCharArray().forEach {
            ++count[it.toInt()]
        }
        var result = 0
        count.forEach {
            result += it.shr(1).shl(1)
            if (result % 2 == 0 && it % 2 == 1) {
                ++result
            }
        }
        return result
    }
}