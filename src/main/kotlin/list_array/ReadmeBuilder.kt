package list_array

fun main() {
    val lineNumber = 1
    val title = "148. Sort List"
    val titleLink = "https://leetcode.com/problems/sort-list/"
    val javaClassName = "SortList148"
    val kotlinClassName = "SortListKotlin148"

    // val level = "Hard"
    val level = "Medium"
    // val level = "Easy"

    val youtubeId = "wOctIHDiV2Q"
    val bilibiliId = "BV1EK4y1h7xh"
    val ixiguaId = "6883143330016789000"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/list_array/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/list_array/$kotlinClassName.kt"

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