package dynamic_programming

fun main() {
    val lineNumber = 8
    val title = "312. Burst Balloons"
    val titleLink = "https://leetcode.com/problems/burst-balloons/"
    val javaClassName = "BurstBalloons312"
    val kotlinClassName = "-"

    val youtubeId = "iD2i-qaBUms"
    val bilibiliId = "BV18t4y1k7Qi"
    val ixiguaId = "6906201404054962695"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/dynamic_programming/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/dynamic_programming/$kotlinClassName.kt"

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