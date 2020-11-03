package string_integer

class ConsecutiveCharactersKotlin1446 {
    fun maxPower(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        var max = 1
        var currentChar = s[0]
        var count = 0
        for (c in s.toCharArray()) {
            if (c == currentChar) {
                ++count
                max = Math.max(max, count)
            } else {
                count = 1
                currentChar = c
            }
        }
        return max
    }
}