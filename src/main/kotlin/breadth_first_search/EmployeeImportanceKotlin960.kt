package breadth_first_search

import java.util.*

class EmployeeImportanceKotlin960 {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val map = employees.filterNotNull().associateBy(Employee::id)
        val queue: Queue<Employee> = LinkedList()

        queue.offer(map.getValue(id))

        var result = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            result += current.importance
            current.subordinates.forEach {
                queue.offer(map.getValue(it))
            }
        }
        return result
    }

    data class Employee(
        var id: Int = 0,
        var importance: Int = 0,
        var subordinates: List<Int> = listOf()
    )
}

fun main() {
    val solution = EmployeeImportanceKotlin960()
    val e1 = EmployeeImportanceKotlin960.Employee(1, 5, listOf(2, 3))
    val e2 = EmployeeImportanceKotlin960.Employee(2, 3, listOf())
    val e3 = EmployeeImportanceKotlin960.Employee(3, 3, listOf())
    println(solution.getImportance(listOf(e1, e2, e3), 1))
}