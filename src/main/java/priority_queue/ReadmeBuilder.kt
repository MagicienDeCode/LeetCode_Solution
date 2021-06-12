package priority_queue

fun main() {
    val lineNumber = 2
    val title = "871. Minimum Number of Refueling Stops"
    val titleLink = "https://leetcode.com/problems/minimum-number-of-refueling-stops/"
    val javaClassName = "MinimumNumberofRefuelingStops871"
    val kotlinClassName = "-"

    val youtubeId = "mKtDw8HAcag"
    val bilibiliId = "BV1h44y167Nj"
    val ixiguaId = "6972954543017427470"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/priority_queue/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/priority_queue/$kotlinClassName.kt"

    val kotlinFinal = if (kotlinClassName == "-") "-" else "[Kotlin]($kotlinLink)"


    val result = """
            |$lineNumber|[$title]($titleLink)
            |[Java]($javaLink)
            |$kotlinFinal
            |Hard
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