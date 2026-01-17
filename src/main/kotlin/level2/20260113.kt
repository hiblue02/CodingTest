package org.example.level2


fun solution(n: Int): Int {
    val antiDiagonal = BooleanArray(2 * n - 1) // /
    val mainDiagonal = BooleanArray(2 * n - 1) // \
    val cols = BooleanArray(n)
    var answer: Int = 0

    fun place(row: Int) {
        if (row == n) {
            answer++; return
        }
        for (col in 0 until n) {
            val anti = row + col
            val main = row - col + (n - 1)
            if (antiDiagonal[anti] || mainDiagonal[main] || cols[col]) continue
            cols[col] = true
            antiDiagonal[anti] = true
            mainDiagonal[main] = true
            place(row + 1)
            cols[col] = false
            antiDiagonal[anti] = false
            mainDiagonal[main] = false
        }
    }

    place(0)

    return answer
}

fun main() {
    val result = solution(4)
    println(result)
}
