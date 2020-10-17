package bit_operation

class RepeatedDNASequencesKotlin187 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        val results: MutableSet<String> = HashSet()
        val set: MutableSet<String> = HashSet()
        var i = 0
        while (i + 9 < s.length) {
            val current = s.substring(i, i + 10)
            if (set.contains(current)) {
                results.add(current)
            } else {
                set.add(current)
            }
            i++
        }
        return results.toList()
    }
}