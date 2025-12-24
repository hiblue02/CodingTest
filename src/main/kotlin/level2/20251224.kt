package org.example.level2

/**
 * 네트워크
 */
fun solution1223(n: Int, computers: Array<IntArray>): Int {


    fun bfs(visited: BooleanArray, now: Int) {
        val queue = mutableListOf<Int>()
        visited[now] = true
        queue.add(now)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            for (i in 0 until n) {
                if (!visited[i] && computers[current][i] == 1) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
    }

    var answer = 0
    val visited = BooleanArray(n)
    for (i in 0 until n) {
        if (visited[i]) {
            continue
        } else {
            bfs(visited, i)
            answer++
        }

    }



    return answer
}

/**
 * 단어변환
 */
fun solution(begin: String, target: String, words: Array<String>): Int {
    var answer = Integer.MAX_VALUE
    val visited = BooleanArray(words.size)

    fun canVisit(source: String, target: String): Boolean =
        source.filterIndexed { index, value ->
            value != target[index]
        }.count() == 1


    fun find(current: String, depth: Int) {
        if (current == target) {
            answer = minOf(answer, depth)
            return
        }

        for (index in words.indices) {
            if (!visited[index] && canVisit(current, words[index])) {
                visited[index] = true
                find(words[index], depth + 1)
                visited[index] = false
            }
        }
    }


    find(begin, 0)

    return if(answer == Integer.MAX_VALUE) 0 else answer
}
