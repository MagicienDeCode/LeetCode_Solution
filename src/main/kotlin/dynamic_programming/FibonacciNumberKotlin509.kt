package dynamic_programming

class FibonacciNumberKotlin509 {
    fun fib(N: Int): Int {
        if (N <= 1) {
            return N
        }
        var current = N - 1
        var int1 = 0
        var int2 = 1
        while (current > 0) {
            val sum = int1 + int2
            int1 = int2
            int2 = sum
            --current
        }
        return int2
    }
}

fun main() {
    val solution = FibonacciNumberKotlin509()
    println(solution.fib(0))
    println(solution.fib(1))
    println(solution.fib(2))
    println(solution.fib(3))
    println(solution.fib(4))
}