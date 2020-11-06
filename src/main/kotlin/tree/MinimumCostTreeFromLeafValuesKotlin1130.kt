package tree

import java.util.*

class MinimumCostTreeFromLeafValuesKotlin1130 {
    /*
    // 7 12 8 10
    public int mctFromLeafValues(int[] arr) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            result += arr[i] * arr[i - 1];
        }
        return result;
    }
     */
    fun mctFromLeafValues(arr: IntArray): Int {
        val stack = Stack<Int>()
        var result = 0
        stack.push(arr[0])
        for (i in 1 until arr.size) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                val pop = stack.pop()
                result += if (stack.size == 0) {
                    pop * arr[i]
                } else {
                    pop * Math.min(arr[i], stack.peek())
                }
            }
            stack.push(arr[i])
        }
        while (stack.size > 1) {
            result += stack.pop() * stack.peek()
        }
        return result
    }
}