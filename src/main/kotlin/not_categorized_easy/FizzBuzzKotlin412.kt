package not_categorized_easy

import java.util.*

class FizzBuzzKotlin412 {
    fun fizzBuzz(n: Int): List<String> {
        val result: MutableList<String> = LinkedList()
        for (i in 1..n) {
            when {
                i % 3 == 0 -> {
                    when {
                        i % 5 == 0 -> result.add("FizzBuzz")
                        else -> result.add("Fizz")
                    }
                }
                i % 5 == 0 -> {
                    result.add("Buzz")
                }
                else -> result.add(i.toString())
            }
        }
        return result
    }
}