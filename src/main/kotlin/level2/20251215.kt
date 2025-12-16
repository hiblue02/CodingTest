package org.example.level2

import kotlin.math.min
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
fun solution5(clothes: Array<Array<String>>): Int {
    return clothes.groupBy { it[1] }
        .map { (_, items) -> items.size + 1 }
        .reduce { acc, count -> acc * count }
        .minus(1)
}

/**
 * 베스트앨범
 */
fun solution(genres: Array<String>, plays: IntArray): IntArray {

    // 장르로 그룹 만들고 <인덱스, 재생횟수> List 저장
    data class song(val index: Int, val genre: String, val playCount: Int)

    val store = genres.mapIndexed { index, genre -> song(index, genre, plays[index]) }
        .groupBy { it.genre }

    // 장르별 재생횟수 합산 후 내림차순 정렬
    val genrePlayCount = store.mapValues { entries -> entries.value.sumOf { it.playCount } }
        .toList()
        .sortedByDescending { it.second }

    // 장르별로 재생횟수 높은 노래 2곡씩 선택
    val result = mutableListOf<Int>()
    for ((genre, _) in genrePlayCount) {
        val songs = store[genre]!!.toList().sortedByDescending { it.playCount }
        result.add(songs[0].index)
        if (songs.size > 1) {
            result.add(songs[1].index)
        }
    }

    return result.toIntArray()
}

fun solution2(genres: Array<String>, plays: IntArray): IntArray {
    return genres.indices.groupBy { genres[it] }
        .toList()
        .also { println("$it") }
        .sortedByDescending { it.second.sumOf { plays[it] } }
        .also { println("$it") }
        .map { it.second.sortedByDescending { plays[it] }.take(2) }
        .also { println("$it") }
        .flatten()
        .toIntArray()

}

/**
 * 송전탑
 * n은 2 이상 100 이하인 자연수입니다.
 * wires는 길이가 n-1인 정수형 2차원 배열입니다.
 * wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
 * 1 ≤ v1 < v2 ≤ n 입니다.
 * 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
 */

fun solution3(n: Int, wires: Array<IntArray>): Int {
    fun count(graph: MutableMap<Int, MutableList<Int>>, start: Int): Int {
        val visited = mutableSetOf<Int>()
        val queue = ArrayDeque<Int>()
        visited.add(start); queue.add(start)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            graph[node]?.forEach { next ->
                if (next !in visited) {
                    visited.add(next); queue.add(next)
                }
            }
        }
        return visited.size
    }

    var minDiff = n
    for (wire in wires) {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        wires.filter { it != wire }.forEach { (a,b)->
            graph.getOrPut(a) { mutableListOf() }.add(b)
            graph.getOrPut(b) { mutableListOf() }.add(a)
        }
        val count1 = count(graph, wire[0])
        val count2 = n - count1
        minDiff = minOf(minDiff, kotlin.math.abs(count1 - count2))
    }

    return minDiff
}

fun main() {
    solution2(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500))
}
