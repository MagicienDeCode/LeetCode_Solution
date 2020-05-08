package nottcategorized

class CheckIfItIsaStraightLineKotlin1232 {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val firstPoint = coordinates[0]
        val secondPoint = coordinates[1]
        val deltaX = firstPoint[0] - secondPoint[0]
        val deltaY = firstPoint[1] - secondPoint[1]
        for (index in 2 until coordinates.size) {
            val currentDx = coordinates[index][0] - coordinates[index - 1][0]
            val currentDy = coordinates[index][1] - coordinates[index - 1][1]
            if (deltaX * currentDy != deltaY * currentDx) {
                return false
            }
        }
        return true
    }
    /*
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        // y = k * x + b
        val firstPoint = coordinates[0]
        val secondPoint = coordinates[1]
        val deltaX = if (firstPoint[0] - secondPoint[0] == 0) 1 else firstPoint[0] - secondPoint[0]
        val deltaY = firstPoint[1] - secondPoint[1]
        val k = deltaY / deltaX
        val b = firstPoint[1] - k * firstPoint[0]
        for (index in 2 until coordinates.size) {
            val currentPoint = coordinates[index]
            if (currentPoint[1] != k * currentPoint[0] + b) {
                return false
            }
        }
        return true
    }
     */
}

fun main() {
    val solution = CheckIfItIsaStraightLineKotlin1232()
    println(
        solution.checkStraightLine(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5)
            )
        )
    )
    println(
        solution.checkStraightLine(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(1, 1),
                intArrayOf(2, 3)
            )
        )
    )
    println(
        solution.checkStraightLine(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 3),
                intArrayOf(-4, -7),
                intArrayOf(5, 11)
            )
        )
    )
}