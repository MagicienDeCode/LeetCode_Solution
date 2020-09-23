package tree

fun main() {
    val lineNumber = 1
    val title = "623. Add One Row to Tree"
    val titleLink = "https://leetcode.com/problems/add-one-row-to-tree/"
    val javaClassName = "AddOneRowtoTree623"
    val kotlinClassName = "AddOneRowtoTreeKotlin623"

    // val level = "Hard"
    val level = "Medium"
    // val level = "Easy"

    val youtubeId = "NLJsy4CaEYE"
    val bilibiliId = "BV1tt4y1q73A"
    val ixiguaId = "6875720610094252558"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/tree/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/tree/$kotlinClassName.kt"

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