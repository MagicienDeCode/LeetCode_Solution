package not_categorized

class JewelsandStonesKotlin771 {
    fun numJewelsInStones(J: String, S: String): Int {
        // 164ms use HashSet
        val jCharSet = J.toHashSet()
        // 180ms because use LinkedHashSet
        // val jCharSet = J.toSet()
        return S.count { jCharSet.contains(it) }
    }
}