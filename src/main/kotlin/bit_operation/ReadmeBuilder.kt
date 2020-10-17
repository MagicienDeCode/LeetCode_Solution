package bit_operation

fun main() {
    val lineNumber = 1
    val title = "187. Repeated DNA Sequences"
    val titleLink = "https://leetcode.com/problems/repeated-dna-sequences/"
    val javaClassName = "RepeatedDNASequences187"
    val kotlinClassName = "RepeatedDNASequencesKotlin187"

    // val level = "Hard"
    val level = "Medium"
    // val level = "Easy"

    val youtubeId = "kL8GevQ7Rg4"
    val bilibiliId = "BV1Na4y1L7eZ"
    val ixiguaId = "6884589266194661895"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/bit_operation/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/bit_operation/$kotlinClassName.kt"

    val result = """
            |$lineNumber|[$title]($titleLink)
            |[Java]($javaLink)
            |[Kotlin]($kotlinLink)
            |$level
            |[Youtube]($youtube)
            |[bilibili]($bilibili)
            |[ixigua]($ixigua)
            |
        """.trimIndent()

    println(result.replace("\n", ""))
}

/*
|1|[704. Binary Search](https://leetcode.com/problems/binary-search/)
|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binarysearch/BinarySearch704.java)
|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binarysearch/BinarySearchKotlin704.kt)
|Easy
|[Youtube](https://www.youtube.com/watch?v=boLrycDV8jA)
|[bilibili](https://www.bilibili.com/video/av97758021/)
|[ixigua](https://www.ixigua.com/i6806012949392523783/)
|
 */