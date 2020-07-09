package breadth_first_search

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class CloneGraphKotlin133 {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return node
        }

        val mapOldToNew: MutableMap<Node, Node> = HashMap()

        // bfs get all nodes
        val allNode: List<Node> = bfs(node)

        // copy nodes
        allNode.forEach {
            val new = Node(it.`val`)
            mapOldToNew[it] = new
        }

        // copy neighbors
        allNode.forEach { n ->
            val new = mapOldToNew.getValue(n)
            n.neighbors.forEach { neighbor ->
                new.neighbors.add(mapOldToNew.getValue(neighbor!!))
                Unit
            }
        }

        return mapOldToNew[node]
    }

    private fun bfs(node: Node): List<Node> {
        val set: MutableSet<Node> = HashSet()
        val queue: Queue<Node> = LinkedList()
        queue.offer(node)
        set.add(node)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (neighbor in current.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor)
                    set.add(neighbor!!)
                }
            }
        }
        return set.toList()
    }

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }
}

fun main() {
    val node1 = CloneGraphKotlin133.Node(1)
    val node2 = CloneGraphKotlin133.Node(2)
    val node3 = CloneGraphKotlin133.Node(3)
    val node4 = CloneGraphKotlin133.Node(4)
    node2.neighbors.add(node4)
    node1.neighbors.add(node3)
    node2.neighbors.add(node4)
    node1.neighbors.add(node3)
    val solution = CloneGraphKotlin133()
    val r = solution.cloneGraph(node2)
}