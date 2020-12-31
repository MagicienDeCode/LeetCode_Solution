package stack

fun main() {
    val lineNumber = 1
    val title = "84. Largest Rectangle in Histogram"
    val titleLink = "https://leetcode.com/problems/largest-rectangle-in-histogram/"
    val javaClassName = "LargestRectangleinHistogram84"
    val kotlinClassName = "-"

    val level = "Hard"
    // val level = "Medium"
    // val level = "Easy"

    val youtubeId = "nEd-QQFldCo"
    val bilibiliId = "BV1dA411p7DF"
    val ixiguaId = "6912403778180383239"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/stack/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/stack/$kotlinClassName.kt"

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