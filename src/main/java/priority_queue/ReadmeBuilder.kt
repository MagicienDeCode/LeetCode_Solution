package priority_queue

fun main() {
    val lineNumber = 2
    val title = "1642. Furthest Building You Can Reach"
    val titleLink = "https://leetcode.com/problems/furthest-building-you-can-reach/"
    val javaClassName = "FurthestBuildingYouCanReach1642"
    val kotlinClassName = "-"

    val youtubeId = "c435cqiPgDM"
    val bilibiliId = "BV1364y1U7Ds"
    val ixiguaId = "6955465383868367368"

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