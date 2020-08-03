package string_integer

class ValidPalindromeIIKotlin680 {
    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        for (index in start..(start + (end - start).shr(1))) {
            if (s[index] != s[end - index + start]) {
                return false
            }
        }
        return true
    }

    fun validPalindrome(s: String): Boolean {
        for (index in 0..s.length / 2) {
            if (s[index] != s[s.length - 1 - index]) {
                return isPalindrome(s, index + 1, s.length - 1 - index) ||
                        isPalindrome(s, index, s.length - 2 - index)
            }
        }
        return true
    }
    /*
    fun validPalindrome(s: String): Boolean {
        val stringBuilder = StringBuilder(s)
        for (index in stringBuilder.indices) {
            val char = stringBuilder[index]
            stringBuilder.deleteCharAt(index)
            if (isPalindrome(stringBuilder.toString())) {
                return true
            }
            stringBuilder.insert(index, char)
        }
        return isPalindrome(s)
    }

    private fun isPalindrome(s: String): Boolean {
        for (index in 0..s.length / 2) {
            if (s[index] != s[s.length - 1 - index]) {
                return false
            }
        }
        return true
    }
     */
}