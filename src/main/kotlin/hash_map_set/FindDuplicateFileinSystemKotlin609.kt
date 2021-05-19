package hash_map_set;

class FindDuplicateFileinSystemKotlin609 {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val map: MutableMap<String, MutableList<String>> = HashMap()
        paths.forEach {
            val rootContents = it.split(" ")
            for (i in 1 until rootContents.size) {
                val firstIndex = rootContents[i].indexOf("(");
                map.computeIfAbsent(rootContents[i].substring(firstIndex + 1, rootContents[i].length - 1)) { ArrayList() }.add(
                        rootContents[0] + "/" + rootContents[i].substring(0, firstIndex)
                )
            }
        }
        return map.values.filter { it.size > 1 }
    }
}
