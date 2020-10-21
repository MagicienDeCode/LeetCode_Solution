package stack

import java.util.*

class AsteroidCollisionKotlin735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (asteroid in asteroids) {
            check(asteroid, stack)
        }
        return stack.toIntArray()
    }

    private fun check(asteroid: Int, stack: Stack<Int>) {
        while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
            if (stack.peek() < -asteroid) {
                stack.pop()
                continue
            }
            if (stack.peek() == -asteroid) {
                stack.pop()
            }
            return
        }
        stack.push(asteroid)
    }
}