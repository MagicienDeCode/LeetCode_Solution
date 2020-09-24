package string_integer

class FindtheDifferenceKotlin389 {
    fun findTheDifference(s: String, t: String): Char {
        val hash = IntArray(26)
        for (i in s.indices) {
            --hash[s[i] - 'a']
            ++hash[t[i] - 'a']
        }
        ++hash[t[t.length - 1] - 'a']
        for (i in hash.indices) {
            if (hash[i] > 0) {
                return ('a'.toInt() + i).toChar()
            }
        }
        return '@'
    }
}