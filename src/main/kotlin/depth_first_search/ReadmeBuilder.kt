package depth_first_search

fun main() {
    val lineNumber = 2
    val title = "721. Accounts Merge"
    val titleLink = "https://leetcode.com/problems/accounts-merge/"
    val javaClassName = "AccountsMerge721"
    val kotlinClassName = "-"

    val youtubeId = "1d2q3hS79vM"
    val bilibiliId = "BV1AK411u7H7"
    val ixiguaId = "6915873299855573512"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/depth_first_search/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/depth_first_search/$kotlinClassName.kt"

    val kotlinFinal = if (kotlinClassName == "-") "-" else "[Kotlin]($kotlinLink)"


    val result = """
            |$lineNumber|[$title]($titleLink)
            |[Java]($javaLink)
            |$kotlinFinal
            |Medium
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