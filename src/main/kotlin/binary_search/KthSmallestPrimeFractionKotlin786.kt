package binary_search

class KthSmallestPrimeFractionKotlin786 {
    fun kthSmallestPrimeFraction(A: IntArray, K: Int): IntArray {
        var left = A[0].toDouble() / A[A.size - 1].toDouble()
        var right = 1.0
        var q = 1
        while (true) {
            val mid: Double = left + (right - left) / 2.0
            var count = 0
            var p = 0
            var end = 1
            for (index in A.indices) {
                while (end < A.size && A[index] >= A[end] * mid) {
                    ++end
                }
                count += A.size - end
                if (end < A.size && p * A[end] < q * A[index]) {
                    p = A[index]
                    q = A[end]
                }
            }
            when {
                count == K -> return intArrayOf(p, q)
                count < K -> left = mid
                else -> right = mid
            }
        }
    }
    /*
    Time Limit Exceeded
    fun kthSmallestPrimeFraction(A: IntArray, K: Int): IntArray {
        val queue: PriorityQueue<Pair<Int, Int>> = PriorityQueue(
            K,
            Comparator { p1, p2 -> compareValues(p2.first / p2.second.toDouble(), p1.first / p1.second.toDouble()) })
        for (i in 0..A.size - 2) {
            for (j in i + 1 until A.size) {
                queue.offer(Pair(A[i], A[j]))
                if (queue.size > K) {
                    queue.poll()
                }
            }
        }
        val result = queue.poll()
        return intArrayOf(result.first, result.second)
    }
     */
}

fun main() {
    val solution = KthSmallestPrimeFractionKotlin786()
    // 2,5
    solution.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 3).forEach(::print)
    println()
    // 1,7
    solution.kthSmallestPrimeFraction(intArrayOf(1, 7), 1).forEach(::print)
    println()
    // 1,47
    solution.kthSmallestPrimeFraction(intArrayOf(1, 29, 47), 1).forEach(::print)
}
