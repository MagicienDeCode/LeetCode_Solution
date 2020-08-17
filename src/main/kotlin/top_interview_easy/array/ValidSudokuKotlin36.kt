package top_interview_easy.array

class ValidSudokuKotlin36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val row = Array(9) { BooleanArray(9) }
        val col = Array(9) { BooleanArray(9) }
        val box = Array(9) { BooleanArray(9) }

        for (i in board.indices) {
            for (j in board[i].indices) {
                val current = board[i][j]
                if (current != '.') {
                    val number = current - '0' - 1
                    val boxIndex = i / 3 * 3 + j / 3
                    if (row[i][number] || col[j][number] || box[boxIndex][number]) {
                        return false
                    }
                    row[i][number] = true
                    col[j][number] = true
                    box[boxIndex][number] = true
                }
            }
        }
        return true
    }
}