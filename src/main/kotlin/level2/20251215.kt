package org.example.level2

import kotlin.math.sqrt

fun solution(numbers: String): Int {

    val visited = BooleanArray(numbers.length) { false }
    val numberSet = mutableSetOf<Int>()

    fun makeNumbers(current: String, depth: Int, maxDepth: Int) {
        if (depth == maxDepth) {
            numberSet.add(current.toInt())
            return
        }
        for (i in numbers.indices) {
            if (!visited[i]) {
                visited[i] = true
                makeNumbers(current + numbers[i], depth + 1, maxDepth)
                visited[i] = false
            }
        }

    }

    fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        if (number == 2) return true
        if (number % 2 == 0) return false
        for (i in 3..sqrt(number.toDouble()).toInt() step 2) {
            if (number % i == 0) return false
        }
        return true
    }


    for (len in 1..numbers.length) {
        makeNumbers("", 0, len)
    }


    return numberSet.count { isPrime(it) }
}
