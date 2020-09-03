package string_integer

class RepeatedSubstringPatternKotlin459 {
    fun repeatedSubstringPattern(s: String): Boolean = s.repeat(1).substring(1, s.length * 2 - 1).contains(s)
}