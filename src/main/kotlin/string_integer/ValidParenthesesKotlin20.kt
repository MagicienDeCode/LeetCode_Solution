package string_integer

import java.util.*

class ValidParenthesesKotlin20 {
    fun isValid(s: String): Boolean {
        val stack: Stack<Char> = Stack()
        s.forEach {
            when (it) {
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                '(' -> stack.push(')')
                else -> {
                    if (stack.isEmpty() || it != stack.pop()) {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}