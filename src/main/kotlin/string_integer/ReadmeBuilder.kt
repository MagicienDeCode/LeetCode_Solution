package string_integer

fun main() {
    val lineNumber = 1
    val title = "47. Permutations II"
    val titleLink = "https://leetcode.com/problems/permutations-ii/"
    val javaClassName = "PermutationsII47"
    val kotlinClassName = "PermutationsIIKotlin47"

    val youtubeId = "iDmnH7pmZRE"
    val bilibiliId = "BV1eD4y1m7Nj"
    val ixiguaId = "6868291736444076552"

    val youtube = "https://www.youtube.com/watch?v=$youtubeId"
    val bilibili = "https://www.bilibili.com/video/$bilibiliId/"
    val ixigua = "https://www.ixigua.com/i$ixiguaId/"

    val pageName = "string_integer"

    val javaLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/$pageName/$javaClassName.java"
    val kotlinLink =
        "https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/$pageName/$kotlinClassName.kt"

    val result = """
            |$lineNumber|[$title]($titleLink)
            |[Java]($javaLink)
            |[Kotlin]($kotlinLink)
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