package breadth_first_search

import java.util.*

class SnakesandLaddersKotlin909 {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        if (board.isEmpty()) {
            return 0
        }
        // visited, queue
        val visited = BooleanArray(board.size * board.size + 1)
        val queue: Queue<Int> = LinkedList()
        queue.offer(1)
        visited[1] = true
        // BFS
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current == board.size * board.size) {
                    return level
                }
                for (next in current + 1..minOf(current + 6, board.size * board.size)) {
                    val nextCoordinate = getCoordinate(next, board.size)
                    val nextValueBoard = board[nextCoordinate.first][nextCoordinate.second]
                    val nextValue = if (nextValueBoard == -1) {
                        next
                    } else {
                        nextValueBoard
                    }
                    if (!visited[nextValue]) {
                        queue.offer(nextValue)
                        visited[nextValue] = true
                    }
                }
            }
            ++level
        }
        return -1
    }

    private fun getCoordinate(number: Int, N: Int): Pair<Int, Int> {
        val row = N - 1 - (number - 1) / N
        val column = if (row % 2 == N % 2) {
            N - 1 - (number - 1) % N
        } else {
            (number - 1) % N
        }
        return Pair(row, column)
    }
}

fun main() {
    val solution = SnakesandLaddersKotlin909()
    println(
        solution.snakesAndLadders(
            arrayOf(
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, 35, -1, -1, 13, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, 15, -1, -1, -1, -1)
            )
        )
    )
}