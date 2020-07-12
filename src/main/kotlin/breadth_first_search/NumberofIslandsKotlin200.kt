package breadth_first_search

class NumberofIslandsKotlin200 {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        val visited = Array(grid.size) { IntArray(grid[0].size) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ++count
                    dfs(grid, i, j, visited)
                }
            }
        }
        return count
    }

    private fun dfs(grid: Array<CharArray>, x: Int, y: Int, visited: Array<IntArray>) {
        visited[x][y] = 7
        for (index in deltaX.indices) {
            val nextX = x + deltaX[index]
            val nextY = y + deltaY[index]
            if (inBound(grid, nextX, nextY) &&
                visited[nextX][nextY] == 0 &&
                grid[nextX][nextY] == '1'
            ) {
                visited[nextX][nextY] = 7
                dfs(grid, nextX, nextY, visited)
            }
        }
    }
    /*
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        val visited = Array(grid.size) { IntArray(grid[0].size) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ++count
                    val queue: Queue<Pair<Int, Int>> = LinkedList()
                    queue.offer(Pair(i, j))
                    visited[i][j] = 7
                    while (queue.isNotEmpty()) {
                        val current = queue.poll()
                        val x = current.first
                        val y = current.second
                        for (index in deltaX.indices) {
                            val nextX = x + deltaX[index]
                            val nextY = y + deltaY[index]
                            if (inBound(grid, nextX, nextY) &&
                                visited[nextX][nextY] == 0 &&
                                grid[nextX][nextY] == '1'
                            ) {
                                queue.offer(Pair(nextX, nextY))
                                visited[nextX][nextY] = 7
                            }
                        }
                    }
                }
            }
        }
        return count
    }
     */

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<CharArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = NumberofIslandsKotlin200()
    println(
        solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
    )
    println(
        solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '0', '1', '1', '0'),
                charArrayOf('0', '0', '0', '0', '1')
            )
        )
    )
}