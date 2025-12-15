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

/**
 * 카펫
 */
fun solution2(brown: Int, yellow: Int): IntArray {
    val total = brown + yellow
    for (height in 3..total) {
        if (total % height == 0) {
            val width = total / height
            if ((width - 2) * (height - 2) == yellow) {
                return intArrayOf(width, height)
            }
        }
    }
    return intArrayOf(0, 0)
}

/**
 * 카펫 다른 풀이
 */
fun solution3(brown: Int, yellow: Int): IntArray {
    val total = brown + yellow

    for (height in 3..sqrt(total.toDouble()).toInt()) {
        if (total % height > 0) continue

        val width = total / height
        val inner = (width - 2) * (height - 2)

        if (inner == yellow) {
            return intArrayOf(width, height)
        }
    }
    return intArrayOf(0, 0)
}

/**
 * 피로도
 */
fun solution4(k: Int, dungeons: Array<IntArray>): Int {
    var maxCount = 0
    val visited = BooleanArray(dungeons.size) { false }

    fun explore(current: Int, count: Int) {
        maxCount = maxOf(maxCount, count)
        for (i in dungeons.indices) {
            if (!visited[i] && current >= dungeons[i][0]) {
                visited[i] = true
                explore(current - dungeons[i][1], count + 1)
                visited[i] = false
            }
        }
    }


    explore(k, 0)
    return maxCount
}

/**
 * 의상
 */
fun solution(clothes: Array<Array<String>>): Int {
    return clothes.groupBy { it[1] }
        .map { (_, items) -> items.size + 1 }
        .reduce { acc, count -> acc * count }
        .minus(1)
}
