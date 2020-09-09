package string_integer

import java.util.HashMap

class WordPatternKotlin290 {
    fun wordPattern(pattern: String, str: String): Boolean {
        val strings = str.split(" ")
        if (pattern.length != strings.size) {
            return false
        }
        val csMap = HashMap<Char, String>()
        val scMap = HashMap<String, Char>()
        for (i in strings.indices) {
            val c = pattern[i]
            val s = strings[i]
            if (!csMap.containsKey(c)) {
                if (scMap.containsKey(s)) {
                    return false
                } else {
                    csMap[c] = s
                    scMap[s] = c
                }
            } else {
                if (csMap[c] != s) {
                    return false
                }
            }
        }
        return true
    }
}