package org.example.level2

import kotlin.math.pow

/**
 *  사전에서 몇 번째 단어인지 반환하기
 */
fun solution11(word: String): Int {
    // 백트래킹으로 사전 만들기
    val chars = arrayOf('A', 'E', 'I', 'O', 'U')
    val visited = BooleanArray(5) { false }
    val dictionary = mutableListOf<String>()
    fun makeDictionary(current: String, depth: Int, maxDepth: Int) {
        if (depth == maxDepth) {
            dictionary.add(current); return
        }

        if (!visited[depth]) {
            for (char in chars.indices) {
                visited[depth] = true
                makeDictionary("${current + chars[char].toString()}", depth + 1, maxDepth)
                visited[depth] = false
            }
        }
    }

    for (i in 1..chars.size) {
        makeDictionary("", 0, i)
    }

    val sorted = dictionary.sorted()
    // 순서 찾아 반환하기
    return sorted.indexOf(word) + 1
}

fun solution12(word: String): Int {
    val chars = arrayOf('A', 'E', 'I', 'O', 'U')
    val weights = IntArray(5) { index ->
        (0..(4 - index)).sumOf { 5.0.pow(it.toDouble()).toInt() }
    }
    var answer = 0
    word.forEachIndexed { index, char ->
        val charIndex = chars.indexOf(char)
        answer += charIndex * weights[index]
    }
    return answer
}


fun solution13(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()
    return answer
}

