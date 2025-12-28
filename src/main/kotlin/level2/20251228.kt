package org.example.level2

/**
 * N으로 표현
 * 11 = 22 / 2
 */
fun solution1122(N: Int, number: Int): Int {

    val sets = List(9) { mutableSetOf<Int>() }

    for (i in 1..8) {
        sets[i].add(N.toString().repeat(i).toInt())

        for (j in 1..i) {
            for (op1 in sets[j]) {
                for (op2 in sets[j - i]) {
                    sets[i].add(op2 * op1)
                    sets[i].add(op2 / op1)
                    sets[i].add(op2 - op1)
                    if (op1 > 0) sets[i].add(op2 / op1)
                }
            }
        }

        if (sets[i].contains(number)) return i
    }

    return -1
}


fun solution1228_1(triangle: Array<IntArray>): Int {
    for (i in 1 until triangle.size) {
        for (j in 0 until triangle[i].size) {
            val left = if (j > 0) triangle[i - 1][j - 1] else 0;
            val right = if(j < triangle[i-1].size) triangle[i - 1][j] else 0;
            triangle[i][j] = maxOf(triangle[i][j] + left, triangle[i][j] + right)
        }
    }
   return triangle.last().sorted().last()
}

fun main() {
    val triangle: Array<IntArray> = arrayOf(
        intArrayOf(7),
        intArrayOf(3, 8),
        intArrayOf(8, 1, 0),
        intArrayOf(2, 7, 4, 4),
        intArrayOf(4, 5, 2, 6, 5)
    )

    val answer = solution1228_1(triangle)
    println(answer)
}
