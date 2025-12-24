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

    return if (answer == Integer.MAX_VALUE) 0 else answer
}

/**
 * 여행경로
 */
fun solution(tickets: Array<Array<String>>): Array<String> {
    val paths = ArrayList<ArrayList<String>>()
    val visited = BooleanArray(tickets.size)
    fun pass(current: ArrayList<String>, depth: Int) {
        if (depth == tickets.size) {
            paths.add(current)
            return
        }
        val now = current.lastOrNull()!!
        for (index in tickets.indices) {
            if (!visited[index] && (now == tickets[index][0])) {
                visited[index] == true
                current.add(tickets[index][1])
                pass(current, depth+1)
                current.removeLast()
                visited[index] == false
            }
        }
    }

    val current = arrayListOf("ICN")
    pass(current, 0)

    return paths.minByOrNull { it.joinToString ()}!!.toTypedArray()

}
