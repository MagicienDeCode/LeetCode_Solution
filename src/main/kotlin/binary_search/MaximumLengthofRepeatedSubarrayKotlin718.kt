package binary_search

class MaximumLengthofRepeatedSubarrayKotlin718 {
    fun findLength(A: IntArray, B: IntArray): Int {
        val stringA = A.map { it.toChar() }.joinToString("")
        val stringB = B.map { it.toChar() }.joinToString("")
        var left = 0
        var right = minOf(A.size, B.size)
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                isValidLength(stringA, stringB, mid) -> left = mid
                else -> right = mid
            }
        }
        return when {
            isValidLength(stringA, stringB, right) -> right
            else -> left
        }
    }

    private fun isValidLength(stringA: String, stringB: String, target: Int): Boolean {
        val stringASet = mutableSetOf<String>()
        for (index in IntRange(0, stringA.length - target)) {
            stringASet.add(stringA.substring(index, index + target))
        }
        for (index in IntRange(0, stringB.length - target)) {
            if (stringASet.contains(stringB.substring(index, index + target))) {
                return true
            }
        }
        return false
    }
    /*
    fun findLength(A: IntArray, B: IntArray): Int {
        var maxLength = 0
        // S(n*n)
        val dynamicProgramming = Array(A.size + 1) { IntArray(B.size + 1) { 0 } }
        // O(n*n)
        for (indexA in A.indices) {
            for (indexB in B.indices) {
                if (A[indexA] == B[indexB]) {
                    dynamicProgramming[indexA + 1][indexB + 1] = 1 + dynamicProgramming[indexA][indexB]
                    maxLength = maxOf(maxLength, dynamicProgramming[indexA + 1][indexB + 1])
                }
            }
        }
        return maxLength
    }
     */
    /*
     2*n*n
     fun findLength(A: IntArray, B: IntArray): Int {
         return maxOf(compareStartElement(A, B), compareStartElement(B, A))
     }

     private fun compareStartElement(A: IntArray, B: IntArray): Int {
         var maxLength = 0
         for (indexA in A.indices) {
             var startA = indexA
             var startB = 0
             var count = 0
             while (startA < A.size && startB < B.size) {
                 if (A[startA++] == B[startB++]) {
                     count++
                     maxLength = maxOf(maxLength, count)
                 } else {
                     count = 0
                 }
             }
         }
         return maxLength
     }
      */
    /*
    n*n*n
    fun findLength(A: IntArray, B: IntArray): Int {
        var maxLength = 0
        A.forEachIndexed { indexA, a ->
            B.forEachIndexed { indexB, b ->
                if (a == b) {
                    var startA = indexA + 1
                    var startB = indexB + 1
                    var count = 1
                    maxLength = maxOf(maxLength, count)
                    while (startA < A.size &&
                        startB < B.size &&
                        A[startA] == B[startB]
                    ) {
                        count++
                        maxLength = maxOf(maxLength, count)
                        startA++
                        startB++
                    }
                }
            }
        }
        return maxLength
    }
     */
}

fun main() {
    val solution = MaximumLengthofRepeatedSubarrayKotlin718()
    println(solution.findLength(intArrayOf(1, 2, 3, 2, 1), intArrayOf(4, 3, 2, 1, 7)))
    println(solution.findLength(intArrayOf(70, 39, 25, 40, 7), intArrayOf(52, 20, 67, 5, 31)))
}