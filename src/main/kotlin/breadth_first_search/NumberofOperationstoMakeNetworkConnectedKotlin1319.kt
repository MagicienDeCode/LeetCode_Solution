package breadth_first_search

class NumberofOperationstoMakeNetworkConnectedKotlin1319 {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) {
            return -1
        }
        val unionFinds = IntArray(n)
        for (index in unionFinds.indices) {
            unionFinds[index] = index
        }
        connections.forEach {
            val c1 = unionFind(unionFinds, it[0])
            val c2 = unionFind(unionFinds, it[1])
            unionFinds[c1] = c2
        }

        var result = 0
        unionFinds.forEachIndexed { index, i ->
            if (index == i) {
                ++result
            }
        }
        return result - 1
    }

    private fun unionFind(unionFinds: IntArray, target: Int): Int {
        if (unionFinds[target] == target) {
            return target
        }
        return unionFind(unionFinds, unionFinds[target])
    }
    /*
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) {
            return -1
        }
        val visited = BooleanArray(n)
        connections.forEach {
            visited[it[0]] = true
            visited[it[1]] = true
        }

        return visited.count { !it }
    }
     */
}

fun main() {
    val solution = NumberofOperationstoMakeNetworkConnectedKotlin1319()
    // 13
    println(
        solution.makeConnected(
            100,
            arrayOf(
                intArrayOf(17, 51),
                intArrayOf(33, 83),
                intArrayOf(53, 62),
                intArrayOf(25, 34),
                intArrayOf(35, 90),
                intArrayOf(29, 41),
                intArrayOf(14, 53),
                intArrayOf(40, 84),
                intArrayOf(41, 64),
                intArrayOf(13, 68),
                intArrayOf(44, 85),
                intArrayOf(57, 58),
                intArrayOf(50, 74),
                intArrayOf(20, 69),
                intArrayOf(15, 62),
                intArrayOf(25, 88),
                intArrayOf(4, 56),
                intArrayOf(37, 39),
                intArrayOf(30, 62),
                intArrayOf(69, 79),
                intArrayOf(33, 85),
                intArrayOf(24, 83),
                intArrayOf(35, 77),
                intArrayOf(2, 73),
                intArrayOf(6, 28),
                intArrayOf(46, 98),
                intArrayOf(11, 82),
                intArrayOf(29, 72),
                intArrayOf(67, 71),
                intArrayOf(12, 49),
                intArrayOf(42, 56),
                intArrayOf(56, 65),
                intArrayOf(40, 70),
                intArrayOf(24, 64),
                intArrayOf(29, 51),
                intArrayOf(20, 27),
                intArrayOf(45, 88),
                intArrayOf(58, 92),
                intArrayOf(60, 99),
                intArrayOf(33, 46),
                intArrayOf(19, 69),
                intArrayOf(33, 89),
                intArrayOf(54, 82),
                intArrayOf(16, 50),
                intArrayOf(35, 73),
                intArrayOf(19, 45),
                intArrayOf(19, 72),
                intArrayOf(1, 79),
                intArrayOf(27, 80),
                intArrayOf(22, 41),
                intArrayOf(52, 61),
                intArrayOf(50, 85),
                intArrayOf(27, 45),
                intArrayOf(4, 84),
                intArrayOf(11, 96),
                intArrayOf(0, 99),
                intArrayOf(29, 94),
                intArrayOf(9, 19),
                intArrayOf(66, 99),
                intArrayOf(20, 39),
                intArrayOf(16, 85),
                intArrayOf(12, 27),
                intArrayOf(16, 67),
                intArrayOf(61, 80),
                intArrayOf(67, 83),
                intArrayOf(16, 17),
                intArrayOf(24, 27),
                intArrayOf(16, 25),
                intArrayOf(41, 79),
                intArrayOf(51, 95),
                intArrayOf(46, 47),
                intArrayOf(27, 51),
                intArrayOf(31, 44),
                intArrayOf(0, 69),
                intArrayOf(61, 63),
                intArrayOf(33, 95),
                intArrayOf(17, 88),
                intArrayOf(70, 87),
                intArrayOf(40, 42),
                intArrayOf(21, 42),
                intArrayOf(67, 77),
                intArrayOf(33, 65),
                intArrayOf(3, 25),
                intArrayOf(39, 83),
                intArrayOf(34, 40),
                intArrayOf(15, 79),
                intArrayOf(30, 90),
                intArrayOf(58, 95),
                intArrayOf(45, 56),
                intArrayOf(37, 48),
                intArrayOf(24, 91),
                intArrayOf(31, 93),
                intArrayOf(83, 90),
                intArrayOf(17, 86),
                intArrayOf(61, 65),
                intArrayOf(15, 48),
                intArrayOf(34, 56),
                intArrayOf(12, 26),
                intArrayOf(39, 98),
                intArrayOf(1, 48),
                intArrayOf(21, 76),
                intArrayOf(72, 96),
                intArrayOf(30, 69),
                intArrayOf(46, 80),
                intArrayOf(6, 29),
                intArrayOf(29, 81),
                intArrayOf(22, 77),
                intArrayOf(85, 90),
                intArrayOf(79, 83),
                intArrayOf(6, 26),
                intArrayOf(33, 57),
                intArrayOf(3, 65),
                intArrayOf(63, 84),
                intArrayOf(77, 94),
                intArrayOf(26, 90),
                intArrayOf(64, 77),
                intArrayOf(0, 3),
                intArrayOf(27, 97),
                intArrayOf(66, 89),
                intArrayOf(18, 77),
                intArrayOf(27, 43)
            )
        )
    )
    // 1 2 -1 0
    println(solution.makeConnected(4, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))))
    println(
        solution.makeConnected(
            6, arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(1, 2),
                intArrayOf(1, 3)
            )
        )
    )
    println(
        solution.makeConnected(
            6, arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(1, 2)
            )
        )
    )
    println(
        solution.makeConnected(
            5, arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(3, 4),
                intArrayOf(2, 3)
            )
        )
    )
}