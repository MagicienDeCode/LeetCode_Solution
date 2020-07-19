package breadth_first_search

import java.util.*
import kotlin.collections.ArrayList

class MinesweeperKotlin529 {

    private val deltaX = intArrayOf(0, 0, -1, 1, 1, 1, -1, -1)
    private val deltaY = intArrayOf(-1, 1, 0, 0, 1, -1, -1, 1)
    private fun inBound(
        grid: Array<CharArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size

    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X'
            return board
        }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(Pair(click[0], click[1]))
        visited[click[0]][click[1]] = true
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            board[current.first][current.second] = 'B'
            val nextLevel: MutableList<Pair<Int, Int>> = ArrayList()
            var count = 0
            for (index in 0..7) {
                val nextX = current.first + deltaX[index]
                val nextY = current.second + deltaY[index]
                if (inBound(board, nextX, nextY) &&
                    !visited[nextX][nextY]
                ) {
                    nextLevel.add(Pair(nextX, nextY))
                    if (board[nextX][nextY] == 'M') {
                        ++count
                    }
                }
            }
            if (count == 0) {
                nextLevel.forEach {
                    queue.offer(it)
                    visited[it.first][it.second] = true
                }
            } else {
                board[current.first][current.second] = count.toString().toCharArray()[0]
            }
        }
        return board
    }
}

fun main() {
    val solution = MinesweeperKotlin529()
    val result = solution.updateBoard(
        arrayOf(
            charArrayOf('E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'M', 'M', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E')
        ),
        intArrayOf(3, 0)
    )
    println(result)
}