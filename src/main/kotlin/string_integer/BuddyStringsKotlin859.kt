package string_integer

class BuddyStringsKotlin859 {
    fun buddyStrings(a: String, b: String): Boolean {
        if (a.length != b.length) {
            return false
        }
        val hash = IntArray(26)
        return if (a == b) {
            // if a == b, the only case return true is that a has two identical letters
            for (element in a) {
                // if found two same letters, return true
                if (hash[element - 'a'] > 0) {
                    return true
                }
                ++hash[element - 'a']
            }
            false
        } else {
            // a != b, the only case is we have two index that a[i] != b[i],
            // but ingore the order, all lettres in a and b should be the same.
            var count = 0
            for (i in a.indices) {
                val ai = a[i]
                val bi = b[i]
                if (ai != bi) {
                    ++hash[ai - 'a']
                    --hash[bi - 'a']
                    ++count
                }
            }
            // count must be 2 so that we could swap index i and index j
            if (count != 2) {
                return false
            }
            // a and b should have the same letters
            for (h in hash) {
                if (h != 0) {
                    return false
                }
            }
            true
        }
    }
}