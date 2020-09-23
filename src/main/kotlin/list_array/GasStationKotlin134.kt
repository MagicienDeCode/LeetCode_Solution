package list_array

class GasStationKotlin134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var sum = 0
        var count = 0
        var start = 0
        for (i in gas.indices) {
            val current = gas[i] - cost[i]
            if (count + current < 0) {
                start = i + 1
                count = 0
            } else {
                count += current
            }
            sum += current
        }
        return if (sum < 0) -1 else start
    }
}