package not_categorized

class MaximumNestingDepthofTwoValidParenthesesStringsKotlin1111 {
    fun maxDepthAfterSplit(seq: String): IntArray {
        val result = IntArray(seq.length)
        var leftCount = 0
        var rightCount = 0
        seq.forEachIndexed { index, c ->
            when (c) {
                '(' -> {
                    when {
                        leftCount <= rightCount -> {
                            leftCount++
                            result[index] = 0
                        }
                        else -> {
                            rightCount++
                            result[index] = 1
                        }
                    }
                }
                else -> {
                    when {
                        rightCount <= leftCount -> {
                            rightCount++
                            result[index] = 0
                        }
                        else -> {
                            leftCount++
                            result[index] = 1
                        }
                    }
                }
            }
        }
        return result
    }
}