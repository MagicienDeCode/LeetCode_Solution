package list_array

class RobotBoundedInCircleKotlin1041 {
    fun isRobotBounded(instructions: String): Boolean {
        var x = 0
        var y = 0
        var direction = 0
        val deltaX = intArrayOf(0, 1, 0, -1)
        val deltaY = intArrayOf(1, 0, -1, 0)
        for (c in instructions.toCharArray()) {
            if (c == 'R') {
                direction = (direction + 1) % 4
            } else if (c == 'L') {
                direction = (direction + 3) % 4
            } else {
                x += deltaX[direction]
                y += deltaY[direction]
            }
        }
        return x == 0 && y == 0 || direction > 0
    }
}