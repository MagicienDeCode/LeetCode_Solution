package tree

class RecoveraTreeFromPreorderTraversalKotlin1028 {
    fun recoverFromPreorder(s: String): TreeNode? {
        val chars = s.toCharArray()
        return build(chars, 0, chars.size - 1, 1)
    }

    private fun build(chars: CharArray, startVal: Int, end: Int, level: Int): TreeNode? {
        var start = startVal
        if (start > end) {
            return null
        }
        // convert chars to integer, take example of "405 - - 1 - - 22", the first int is 405, NOT 4
        val stringBuilder = StringBuilder()
        while (start <= end && chars[start] != '-') {
            stringBuilder.append(chars[start])
            start++
        }
        // root of node
        val root = TreeNode(stringBuilder.toString().toInt())
        if (start == end) {
            return root
        }
        // calculate left start
        val leftStart = start + level
        var interval = 0
        var rightStart = leftStart + 1
        // calculate right start, if exists one, it must have count of "-" equals to level
        while (rightStart < chars.size) {
            if (chars[rightStart] == '-') {
                interval++
            } else {
                if (interval == level) {
                    break
                }
                interval = 0
            }
            ++rightStart
        }
        // recalculate left end, it may have rightStart > end, so we take end
        val leftEnd = if (rightStart > end) end else rightStart - level - 1
        // build tree recursively
        root.left = build(chars, leftStart, leftEnd, level + 1)
        root.right = build(chars, rightStart, end, level + 1)
        return root
    }
}