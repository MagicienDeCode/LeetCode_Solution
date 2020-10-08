package tree

class SumofDistancesinTreeKotlin834 {
    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        // build graph and declare results
        val graph: Array<MutableList<Int>> = Array(n) { ArrayList<Int>() }
        val count = IntArray(n) { 1 }
        val answer = IntArray(n)
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        postOrder(0, -1, graph, count, answer)
        // after postOrder, only answer[root] is correct, so do preOrder to update answer
        preOrder(0, -1, graph, count, answer, n)
        return answer
    }

    // set count et subTreeSum, here use answer[]
    private fun postOrder(node: Int, parent: Int, graph: Array<MutableList<Int>>, count: IntArray, answer: IntArray) {
        for (child in graph[node]) {
            if (child != parent) {
                postOrder(child, node, graph, count, answer)
                count[node] += count[child]
                answer[node] += answer[child] + count[child]
            }
        }
    }

    private fun preOrder(node: Int, parent: Int, graph: Array<MutableList<Int>>, count: IntArray, answer: IntArray, n: Int) {
        for (child in graph[node]) {
            if (child != parent) {
                answer[child] = answer[node] + (n - count[child]) - count[child]
                preOrder(child, node, graph, count, answer, n)
            }
        }
    }
}